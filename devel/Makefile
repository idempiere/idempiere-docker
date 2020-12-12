DOCKER_TAG=latest
POSTGRES_VERSION=12

build:
	docker build -t idempiere:$(DOCKER_TAG) ../daily

bash:
	docker run -it --rm idempiere:$(DOCKER_TAG) bash

up:
	docker network create idempiere
	docker run -d --name postgres --network idempiere -p 5432:5432 -e POSTGRES_PASSWORD=postgres postgres:$(POSTGRES_VERSION)
	docker run -d --name idempiere --network idempiere -p 8080:8080 -e DB_HOST=postgres -e DB_PORT=5432 -e DB_NAME=idempiere -e DB_USER=adempiere -e DB_PASS=adempiere -e DB_ADMIN_PASS=postgres idempiere:$(DOCKER_TAG)

stop:
	docker rm -f idempiere postgres
	docker network rm idempiere

compose-up:
	DOCKER_TAG=$(DOCKER_TAG) POSTGRES_VERSION=$(POSTGRES_VERSION) docker-compose up -d

compose-down:
	DOCKER_TAG=$(DOCKER_TAG) POSTGRES_VERSION=$(POSTGRES_VERSION) docker-compose down
