# redis-cluster — IDEMPIERE-6989 distributed-cache test harness

Two iDempiere nodes + one Redis + one Postgres. Validates the
`org.idempiere.redis.service` bundle's clustering, cache invalidation,
heartbeat membership, and circuit breaker against a real multi-node setup.

The bundle being validated lives in the iDempiere fork at
[github.com/cloudempiere/idempiere-fork](https://github.com/cloudempiere/idempiere-fork)
on branch `IDEMPIERE-6989`. Upstream JIRA:
[IDEMPIERE-6989](https://idempiere.atlassian.net/browse/IDEMPIERE-6989).

## Prerequisites

- Docker + docker-compose v2
- Java 17 + Maven (only for building the bundle JAR — the iDempiere containers don't need it)
- A local checkout of the iDempiere fork that includes the IDEMPIERE-6989 branch
- ~6 GB free RAM (4 containers; iDempiere is ~1.5-2 GB each under load)
- ~2 GB free disk for first-time image pulls

## Quickstart

```bash
# 1. Build the bundle JAR and stage it in dropins/
IDEMPIERE_SRC=~/GitHub/idempiere-fork bash build-dropins.sh

# 2. Build the runtime image (bakes the bundle JAR + default config)
docker compose build

# 3. First-boot: bring up postgres + redis + node-a, wait for DB seed,
#    then start node-b. The script sequences this for you so the two
#    nodes don't race on the schema import.
bash scripts/start.sh --seed

# Subsequent boots just need:
#    bash scripts/start.sh         # both nodes at once
# Or vanilla compose (depends_on:service_healthy now sequences this):
#    docker compose up -d

# 4. Watch node-a come up (~3 min on first boot for DB seed)
docker compose logs -f idempiere-a
# Ready when:  "BundleEvent STARTED" for org.idempiere.webui
#         AND  "org.idempiere.redis.service activated as the distributed backend"

# 5. Open the webui (https, self-signed cert -> accept warning)
#    node-a: https://localhost:8443/webui/
#    node-b: https://localhost:8444/webui/
#    Login:  GardenAdmin / GardenAdmin
```

## Validate clustering

```bash
# Heartbeat keys — expect 2 (one per node UUID), TTL 30s
docker exec idmp-redis redis-cli --scan --pattern "idempiere:test-cluster:members:*"

# Watch live cache traffic while editing a record in the webui
docker exec idmp-redis redis-cli MONITOR

# Cluster console (Equinox commands shipped by the bundle)
docker exec -it idmp-a telnet localhost 12612
# In the OSGi console:  redisStatus    - bundle activation state, key prefix, near-cache
#                       redisHealth    - circuit-breaker state and consecutive failures
#                       redisMembers   - live cluster members from heartbeat keys
#                       redisKeys      - count Redis keys matching a glob (defaults to <prefix>*)
#                       redisBound     - which backend is bound for ICacheService etc.
#                       redisKeyspace  - keyspace notification subscriber state and event count
```

## Resilience tests

```bash
# Trip the circuit breaker
docker compose stop redis
docker compose logs -f --tail=50 idempiere-a | grep -i "circuit"
# expect within ~5 failed calls:  "Redis circuit breaker tripped to OPEN after N consecutive failures"

# Recover (probe-interval is 60s by default; probe runs on a background scheduler)
docker compose start redis
# expect within ~60s: "Redis circuit breaker recovered to CLOSED after probe"
```

## Tear down

```bash
docker compose down       # keeps DB + redis volumes (faster restart)
docker compose down -v    # nukes everything; next start re-seeds the DB ~3 min
```

## Configuration

`config/redis.yaml` — Redisson native YAML, mounted into both nodes at
`/opt/idempiere/redis.yaml`. Currently configured for single-server topology
pointing at the compose `redis` service. Switch to `sentinelServersConfig` or
`clusterServersConfig` to test against managed Redis topologies.

`config/redis.properties` — bundle-specific tuning (instance.name, Caffeine
near-cache, circuit breaker), mounted at `/opt/idempiere/redis.properties`.
Both nodes share the same `redis.instance.name=test-cluster` so they discover
each other via heartbeat keys under the `idempiere:test-cluster:` prefix.

`.env.example` — overridable environment (image tag, TZ, postgres password).
Copy to `.env` to apply.

## What's where

| Path | Committed? | Purpose |
|---|---|---|
| `docker-compose.yml` | yes | 4-container stack definition |
| `Dockerfile.redis` | yes | Image overlay on `idempiereofficial/idempiere:13-release` that bakes in the bundle JAR |
| `config/redis.yaml` | yes | Redisson connection config |
| `config/redis.properties` | yes | Bundle tuning |
| `build-dropins.sh` | yes (executable) | Build bundle JAR from `$IDEMPIERE_SRC`, copy into `dropins/` |
| `scripts/start.sh` | yes (executable) | Sequenced bring-up; `--seed` for first-boot, `--single` for postgres+redis+a only |
| `scripts/stop.sh` | yes (executable) | Tear-down; `--wipe` also drops volumes |
| `.env.example` | yes | Reference for overridable env vars |
| `dropins/.gitkeep` | yes | Marker so the folder exists in git |
| `dropins/*.jar` | gitignored | Built bundle JAR |

## Troubleshooting

| Symptom | Likely cause | Fix |
|---|---|---|
| iDempiere logs don't say "activated as the distributed backend" | `JAVA_OPTIONS` env didn't reach the JVM | `docker exec idmp-a env \| grep JAVA_OPTIONS` to verify |
| `redis-cli --scan` returns no `idempiere:*` keys | Heartbeat thread didn't start, or `instance.name` mismatch | `docker exec idmp-a cat /opt/idempiere/redis.properties` |
| Only ONE heartbeat key (not two) | Both nodes have different `instance.name` | Compare both containers — likely a volume-mount typo |
| `https://localhost:8443/webui/` → connection refused | iDempiere still booting (DB seed) or container crashed | `docker compose logs idempiere-a` |
| node-b takes 3 min to start (should be ~30s) | `MIGRATE_EXISTING_DATABASE` set to true, re-seeding the shared DB | Should be unset/false in compose |
| Port collision on 5432 / 6380 / 8443 / 8444 / 12612 / 12613 | Host has a service running on that port | Stop conflicting service or change port mapping in compose |
