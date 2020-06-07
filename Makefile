DOCKER_TAG=latest

build:
	docker build -t idempiere:$(DOCKER_TAG) .

bash:
	docker run -it --rm idempiere:$(DOCKER_TAG) bash

run:
	docker run -d --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres postgres:12
	docker run -d --name idempiere --network host -e DB_HOST=127.0.0.1 -e DB_PORT=5432 -e DB_NAME=idempiere -e DB_USER=adempiere -e DB_PASS=adempiere -e DB_ADMIN_PASS=postgres  idempiereofficial/idempiere:$(DOCKER_TAG)

run-stack:
	docker stack deploy -c docker-stack.yml idempiere

run-compose:
	docker-compose -f docker-stack.yml up

stop:
	docker rm -f idempiere postgres

log:
	docker service logs -f idempiere_idempiere

clean:
	docker volume rm idempiere_idempiere_data || true
	docker volume rm idempiere_idempiere_plugins || true
	docker volume rm idempiere_idempiere_config || true
