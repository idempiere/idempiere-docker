# Dockerizing iDempiere 6.2

- [Docker Hub](https://hub.docker.com/r/ingeint/idempiere)

## Getting Started

```
$ docker swarm init
$ make build run
```

Open in the browser: [http://localhost:8080/webui/](http://localhost:8080/webui/)

## Default Accounts

The following users and passwords are part of the initial seed database:

| Usage | User | Password |
| - | - | - |
| System Management | System | System |
| System Management or any role/company | SuperUser | System |
| Sample Client Administration | GardenAdmin | GardenAdmin |
| Sample Client User | GardenUser | GardenUser |

## How it works

iDempiere starts looking for an existing database, if it don't exist
iDempiere will create a seed database.

> If the database exists iDempiere won't migrate it, you must do it manually, or using `MIGRATE_EXISTING_DATABASE=true`.

Before starting, it will configure all the settings according to
the `setup.sh` or `console-setup.sh` files. See [docker-entrypoint.sh](docker-entrypoint.sh) file.

> This project has not support for oracle database.

## Using from Docker Hub

Image: `ingeint/idempiere`.

```bash
$ docker pull ingeint/idempiere
```

Stack:

```yaml
version: '3.7'

services:
  idempiere:
    image: ingeint/idempiere:6.2
    ports:
      - 8080:8080
```

## Make Commands

`make build` creates iDempiere docker image (with labels `idempiere:6.2` and `idempiere:latest`)

`make run` runs iDempiere docker stack (includes `postgres:9.6`)

`make stop` stops the stack

`make log` shows the logs of iDempiere

`make bash` creates a terminal within iDempiere docker image

## Docker Stack

This is an example of how deploy iDempiere using a docker stack file:

```yaml
version: '3.7'

services:
  idempiere:
    image: idempiere:6.2
    ports:
      - 8080:8080
      - 8443:8443
      - 12612:12612
    environment:
      - TZ=America/Guayaquil

  postgres:
    image: postgres:9.6
    volumes:
      - idempiere_data:/var/lib/postgresql/data
    environment:
      - TZ=America/Guayaquil
      - POSTGRES_PASSWORD=postgres
    ports:
      - 5432:5432

volumes:
  idempiere_data:
```

## Environment Variables

| Variable | Default Value | Description |
| - | - | - |
| IDEMPIERE_HOME | /idempiere | Path to iDempiere |
| IDEMPIERE_VERSION | 6.2 | iDempiere Version |
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

## Default Ports

| Port | Description |
| - | - |
| 8080 | Default HTTP port for iDempiere |
| 8443 | Default HTTPS port for iDempiere |
| 12612 | Default OSGI port for telnet connection |
| 4554 | Default remote debug port |

## Volumes

Postgres Data:

```yaml
volumes:
  - idempiere_data:/var/lib/postgresql/data
```

iDempiere Plugins:

```yaml
volumes:
  - idempiere_plugins:/idempiere/configuration
```

## Run as Debug

Adding `command` yml property:
```yaml
command: idempiere debug
```

## Docker Secrets

As an alternative to passing sensitive information via environment variables,
`_FILE` may be appended to some of the previously listed environment variables,
causing the initialization script to load the values for those variables
from files present in the container. See [Docker Secrets](https://docs.docker.com/engine/swarm/secrets/) and [Docker PosgreSQL](https://hub.docker.com/_/postgres).

#### Variable list:

| Variable | Original variable |
| - | - |
| DB_ADMIN_PASS_FILE | DB_ADMIN_PASS |
| DB_PASS_FILE | DB_PASS |
| MAIL_PASS_FILE | MAIL_PASS |
| KEY_STORE_PASS_FILE | KEY_STORE_PASS |

#### Example:

Create the secret:

```bash
$ printf "postgres" | docker secret create db_admin_pass -
```

Use environment variable in the stack file:

```yaml
version: '3.7'

services:
  idempiere:
    image: idempiere:6.2
    ports:
      - 8080:8080
      - 8443:8443
      - 12612:12612
    environment:
      - TZ=America/Guayaquil
      - DB_ADMIN_PASS_FILE=/run/secrets/db_admin_pass
    secrets:
      - db_admin_pass

  postgres:
    image: postgres:9.6
    volumes:
      - idempiere_data:/var/lib/postgresql/data
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
