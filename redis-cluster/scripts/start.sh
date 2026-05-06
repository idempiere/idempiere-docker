#!/usr/bin/env bash
# ============================================================
# start.sh — bring up the redis-cluster harness
# ============================================================
# Usage:
#   bash scripts/start.sh           # both nodes at once (post-first-boot)
#   bash scripts/start.sh --single  # only postgres + redis + node-a
#   bash scripts/start.sh --seed    # safe first-boot: node-a first, wait
#                                   #   for it to seed DB, then node-b
# ============================================================

set -euo pipefail

cd "$(dirname "$0")/.."

MODE="${1:---full}"

case "$MODE" in
  --single)
    echo "Starting postgres + redis + idempiere-a only..."
    docker compose up -d postgres redis idempiere-a
    ;;

  --seed)
    echo "First-boot sequence: postgres + redis + node-a..."
    docker compose up -d postgres redis idempiere-a
    echo
    echo "Waiting for idempiere-a to become healthy (DB seed can take 3-5 min)..."
    while :; do
      status=$(docker inspect -f '{{.State.Health.Status}}' idmp-a 2>/dev/null || echo starting)
      case "$status" in
        healthy)
          echo "idempiere-a is healthy."
          break
          ;;
        unhealthy)
          echo "idempiere-a is UNHEALTHY. Last logs:"
          docker compose logs --tail=50 idempiere-a
          exit 1
          ;;
        *)
          echo "  ...still waiting (status: $status)"
          sleep 15
          ;;
      esac
    done
    echo "Starting node-b..."
    docker compose up -d idempiere-b
    ;;

  --full)
    echo "Starting full stack (both nodes at once — assumes DB already seeded)..."
    docker compose up -d
    ;;

  *)
    echo "Unknown option: $MODE" >&2
    echo "Usage: $0 [--single|--seed|--full]" >&2
    exit 1
    ;;
esac

echo
echo "Container status:"
docker compose ps

echo
echo "Endpoints:"
echo "  node-a webui    https://localhost:8443/webui"
echo "  node-b webui    https://localhost:8444/webui"
echo "  node-a console  telnet localhost 12612"
echo "  node-b console  telnet localhost 12613"
echo "  postgres        psql -h localhost -p 5432 -U postgres -d idempiere"
echo "  redis           redis-cli -p 6380"
echo
echo "Tail logs with: docker compose logs -f idempiere-a"
