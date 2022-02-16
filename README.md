# Quick reference

-	**Maintained by**:  
	[INGEINT](https://ingeint.com)

-	**Where to get help**:  
	[iDempiere Community Forums](https://www.idempiere.org/forums/) or [Mattermost Support Channel](https://mattermost.idempiere.org/idempiere/channels/support)

- **Where to file issues**:  
  [Mattermost Support Channel](https://mattermost.idempiere.org/idempiere/channels/support) or [Github Issues](https://github.com/idempiere/idempiere-docker/issues)

- **Official Links**:  
  [Docker Hub](https://hub.docker.com/r/idempiereofficial/idempiere),
  [Repository](https://github.com/idempiere/idempiere-docker),
  [iDempiere](https://github.com/idempiere/idempiere)


# Supported tags and respective `Dockerfile` links

## iDempiere

Productive iDempiere Environment

-	[`daily`, `latest`](https://github.com/idempiere/idempiere-docker/tree/master/daily)
-	[`7.1`](https://github.com/idempiere/idempiere-docker/tree/master/7.1)
- [`8.2`, `phong`](https://github.com/idempiere/idempiere-docker/tree/master/8.2)
- [`9`, `Horizon`](https://github.com/idempiere/idempiere-docker/tree/master/9)

## iDempiere Source

iDempiere's Source Code for Development Environment

-	[`source-master`](https://github.com/idempiere/idempiere-docker/tree/master/source-master)
-	[`source-release-7.1`](https://github.com/idempiere/idempiere-docker/tree/master/source-release-7.1)
- 	[`source-release-8.2`](https://github.com/idempiere/idempiere-docker/tree/master/source-release-8.2)
- 	[`source-release-9`](https://github.com/idempiere/idempiere-docker/tree/master/source-release-9)

# What is iDempiere?

iDempiere is a powerful, open-source ERP/CRM/SCM system supported by a skilful community. The project focuses on high-quality software, a philosophy of openness and its collaborative community that includes subject matter specialists, implementors, developers and end-users.

iDempiere has earned a strong reputation for its high-quality, architectural design, reliability, robust feature set, extensibility, and the commitment of the open-source community behind the project to consistently develop and improve the software with performant and innovative solutions.

For more information [here](https://www.idempiere.org/about/).

![logo](https://www.idempiere.org/wp-content/uploads/2020/03/cropped-taglinef3-scaled-1.jpg)

# Getting Started

### Using Docker Commands

iDempiere Docker uses a postgres admin password and user to create a clean database, example `POSTGRES_PASSWORD=postgres`, if you are using a different configuration you need to see [Environment Variables](#environment-variables):

```bash
$ docker run -d --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres postgres:13
```
> Remember to change the postgres port in case you have one previously running, example `-p 5433:5432`.
> You could use any postgres version in the [Prerequisites Page](https://wiki.idempiere.org/en/Install_Development_Prerequisites).

```bash
$ docker run -d --name idempiere -p 8443:8443 --link postgres:postgres idempiereofficial/idempiere:9
```

For persistent data see the section [Volumes](#volumes).

Starting containers automatically [here](https://docs.docker.com/config/containers/start-containers-automatically/).

Open in the browser: [https://127.0.0.1:8443/webui/](https://127.0.0.1:8443/webui/)

Please note: From iDempiere version 9 onwards, direct http access is no longer supported. https://wiki.idempiere.org/en/Migration_Notes#Deprecated_direct_http_usage

### Using Docker Commands With an External DB On Linux

```bash
$ docker run -d --name idempiere -p 8443:8443 --network host\
  -e DB_HOST=127.0.0.1\
  -e DB_PORT=5432\
  -e DB_NAME=idempiere\
  -e DB_USER=adempiere\
  -e DB_PASS=adempiere\
  -e DB_ADMIN_PASS=postgres\
  idempiereofficial/idempiere:8.2
```

### For Windows use the ^ symbol instead of \
```bash
$ docker run -d --name idempiere -p 8443:8443 ^
  -e DB_HOST=192.168.100.169 ^
  -e DB_PORT=5432 ^
  -e DB_NAME=idempiere ^
  -e DB_USER=adempiere ^
  -e DB_PASS=adempiere ^
  -e DB_ADMIN_PASS=postgres ^
  idempiereofficial/idempiere:8.2
```

For secrets see the section [Docker Secrets](#docker-secrets).

### Using Docker Stack (Docker Swarm or Docker Compose)

Create a `docker-stack.yml` file:

```yaml
version: '3.7'

services:
  idempiere:
    image: idempiereofficial/idempiere:9
    volumes:
      - idempiere_config:/opt/idempiere/configuration
      - idempiere_plugins:/opt/idempiere/plugins
    environment:
      - TZ=America/Guayaquil
    ports:
      - 8080:8080
      - 8443:8443
      - 12612:12612

  postgres:
    image: postgres:12
    volumes:
      - idempiere_data:/var/lib/postgresql/data
    environment:
      - TZ=America/Guayaquil
      - POSTGRES_PASSWORD=postgres
    ports:
      - 5432:5432

volumes:
  idempiere_data:
  idempiere_plugins:
  idempiere_config:
```

Docker swarm enabled:

```bash
$ docker stack deploy -c docker-stack.yml idempiere
```

Docker compose:

```bash
$ docker-compose -f docker-stack.yml up
```

# Default Accounts

The following users and passwords are part of the initial seed database:

| Usage | User | Password |
| - | - | - |
| System Management | System | System |
| System Management or any role/company | SuperUser | System |
| Sample Client Administration | GardenAdmin | GardenAdmin |
| Sample Client User | GardenUser | GardenUser |

# Environment Variables

| Variable | Default Value | Description |
| - | - | - |
| IDEMPIERE_HOME | /opt/idempiere | Path to iDempiere |
| IDEMPIERE_PLUGINS_HOME | /opt/idempiere/plugins | Path to iDempiere plugins |
| IDEMPIERE_LOGS_HOME | /opt/idempiere/log | Path to iDempiere logs |
| IDEMPIERE_VERSION | Docke Tag | iDempiere Version |
| IDEMPIERE_PORT | 8080 | HTTP port for iDempiere |
| IDEMPIERE_SSL_PORT | 8443 | HTTPS port for iDempiere |
| KEY_STORE_PASS | myPassword | Password for java key store (SSL Certificate) |
| KEY_STORE_ON | idempiere.org | Common Name for SSL Certificate |
| KEY_STORE_OU | iDempiere Docker | Organization Unit for SSL Certificate |
| KEY_STORE_O | iDempiere | Organization for SSL Certificate |
| KEY_STORE_L | iDempiere | Locate/Town for SSL Certificate |
| KEY_STORE_S | CA | State for SSL Certificate |
| KEY_STORE_C | US | Country for SSL Certificate |
| DB_HOST | postgres | Hostname for Postgres database |
| DB_PORT | 5432 | Postgres port |
| DB_NAME | idempiere | iDempiere Database |
| DB_USER | adempiere | User for iDempiere Database |
| DB_PASS | adempiere | Pass for `DB_USER` |
| DB_ADMIN_PASS | postgres | Pass for admin user (`postgres` user) |
| MAIL_HOST | idempiere | Mail server |
| MAIL_USER | info | Mail user |
| MAIL_PASS | info | Mail password |
| MAIL_ADMIN | info@idempiere | Admin e-mail |
| JAVA_HOME | /usr/local/openjdk-11 | Path to java |
| JAVA_OPTS |  | Java execution parameters (e.g. `-Xms` and `-Xmx`) |
| DEBUG_PORT| 4554 | Port for remote debug |
| TELNET_PORT | 12612 | OSGI port for telnet connection |
| MIGRATE_EXISTING_DATABASE | false | Migrate the existing database to latest version |
| IDEMPIERE_BUILD | | iDempiere Build URL |

# Default Ports

| Port | Description |
| - | - |
| 8080 | Default HTTP port for iDempiere |
| 8443 | Default HTTPS port for iDempiere |
| 12612 | Default OSGI port for telnet connection |
| 4554 | Default remote debug port |

# How does it work?

iDempiere starts looking for an existing database, if it don't exist
iDempiere will create a seed database.

> If the database exists iDempiere won't migrate it, you must do it manually, or using `MIGRATE_EXISTING_DATABASE=true`.

Before starting, it will configure all the settings according to
the `setup.sh` or `console-setup.sh` files. See [docker-entrypoint.sh](docker-entrypoint.sh) file.

> This project has not support for oracle database.

# Volumes

### Postgres Data

Docker stack:

```yaml
volumes:
  - idempiere_data:/var/lib/postgresql/data
```

Or adding to bash command:

```bash
-v idempiere_data:/var/lib/postgresql/data
```

### iDempiere Plugins

Docker stack:

```yaml
volumes:
  - idempiere_config:/opt/idempiere/configuration
  - idempiere_plugins:/opt/idempiere/plugins
```

Or adding to bash command:

```bash
-v idempiere_config:/opt/idempiere/configuration -v idempiere_plugins:/opt/idempiere/plugins
```

`idempiere_config` saves the plugins configuration and `idempiere_plugins` is
the path to contain the jar plugin (this one is used to install new plugins).

Other way to share plugins (current folder):

```yaml
volumes:
  - idempiere_config:/opt/idempiere/configuration
  - ./plugins:/opt/idempiere/plugins
```

Or adding to bash command:

```bash
-v idempiere_config:/opt/idempiere/configuration -v ./plugins:/opt/idempiere/plugins
```

### iDempiere Logs

Docker stack:

```yaml
volumes:
  - idempiere_log:/opt/idempiere/log
```

Or adding to bash command:

```bash
-v idempiere_log:/opt/idempiere/log
```

# Run as Debug

Adding `command` yml property:

```yaml
command: idempiere debug
```

Or adding to bash command:

```
docker run -d --name idempiere -p 8443:8443 --link postgres:postgres idempiereofficial/idempiere:9 idempiere debug
```

# Docker Secrets

As an alternative to passing sensitive information via environment variables,
`_FILE` may be appended to some of the previously listed environment variables,
causing the initialization script to load the values for those variables
from files present in the container. See [Docker Secrets](https://docs.docker.com/engine/swarm/secrets/) and [Docker PosgreSQL](https://hub.docker.com/_/postgres).

### Variable list:

| Variable | Original variable |
| - | - |
| DB_ADMIN_PASS_FILE | DB_ADMIN_PASS |
| DB_PASS_FILE | DB_PASS |
| MAIL_PASS_FILE | MAIL_PASS |
| KEY_STORE_PASS_FILE | KEY_STORE_PASS |

### Example:

Create the secret:

```bash
$ printf "postgres" | docker secret create db_admin_pass -
```

Use environment variable in the stack file:

```yaml
version: '3.7'

services:
  idempiere:
    image: idempiereofficial/idempiere:8.2
    environment:
      - TZ=America/Guayaquil
      - DB_ADMIN_PASS_FILE=/run/secrets/db_admin_pass
    secrets:
      - db_admin_pass
    ports:
      - 8080:8080
      - 8443:8443
      - 12612:12612

  postgres:
    image: postgres:12
    environment:
      - TZ=America/Guayaquil
      - POSTGRES_PASSWORD_FILE=/run/secrets/db_admin_pass
    secrets:
      - db_admin_pass
    ports:
      - 5432:5432

volumes:
  idempiere_data:

secrets:
  db_admin_pass:
    external: true
```

# Using iDempiere's sources docker image

Use this images for development purposes.

### Use next tags to download the sources

-	[`source-master`](https://github.com/idempiere/idempiere-docker/tree/master/source-master) corresponding to [iDempiere master brach](https://github.com/idempiere/idempiere/tree/master)
-	[`source-release-7.1`](https://github.com/idempiere/idempiere-docker/tree/master/source-release-7.1) corresponding to [iDempiere release-7.1 brach](https://github.com/idempiere/idempiere/tree/release-7.1)
-	[`source-release-8.2`](https://github.com/idempiere/idempiere-docker/tree/master/source-release-8.2) corresponding to [iDempiere release-8.2 brach](https://github.com/idempiere/idempiere/tree/release-8.2)

### Env Variables

| Variable | Default Value | Description |
| - | - | - |
| IDEMPIERE_REPOSITORY | /source/idempiere | iDempiere Repository Path |
| IDEMPIERE_BRACH | | iDempiere Source Branch |
| SCAFFOLD_REPOSITORY | /source/idempiere-plugin-scaffold | INGEINT Scaffolding Repository Path |
| SCAFFOLD_BRANCH | | INGEINT Scaffolding Source Branch |
| SOURCE_PATH | /source | Sources path |

For more information about the scaffold go [here](https://github.com/ingeint/idempiere-plugin-scaffold)

# Features

- Docker secrets
- Volumes for persistent plugins
- Volumes for persistent logs
- Standard Entrypoint
- Exposed port
- Environment variables
- Auto create and sign db
- Auto migration db
- Openjdk 11
- Continuous integration capable
- Standard output log

# To do
- Oracle DB capable
- On/Off logs to file
- Console setup bypass
- Add TELNET_HOST env var in core idempiere-server.sh file
- Import dump from volume
- Add parameter stop after init

# Development Resources

In [devel](devel) folder.
