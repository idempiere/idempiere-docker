DOCKER_TAG=daily
DOCKER_REPOSITORY=idempiere
POSTGRES_VERSION=12

build:
	docker build -t $(DOCKER_REPOSITORY):$(DOCKER_TAG) ../$(DOCKER_TAG)

bash:
	docker run -it --rm $(DOCKER_REPOSITORY):$(DOCKER_TAG) bash

up:
	docker run -d --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres postgres:$(POSTGRES_VERSION)
	docker run -d --name idempiere --link postgres:postgres -p 8080:8080 -e DB_HOST=postgres -e DB_PORT=5432 -e DB_NAME=idempiere -e DB_USER=adempiere -e DB_PASS=adempiere -e DB_ADMIN_PASS=postgres $(DOCKER_REPOSITORY):$(DOCKER_TAG)

down:
	docker rm -f idempiere postgres

compose-up:
	DOCKER_REPOSITORY=$(DOCKER_REPOSITORY) DOCKER_TAG=$(DOCKER_TAG) POSTGRES_VERSION=$(POSTGRES_VERSION) docker-compose -p idempiere-$(DOCKER_TAG) up -d

compose-down:
	DOCKER_REPOSITORY=$(DOCKER_REPOSITORY) DOCKER_TAG=$(DOCKER_TAG) POSTGRES_VERSION=$(POSTGRES_VERSION) docker-compose -p idempiere-$(DOCKER_TAG) down
