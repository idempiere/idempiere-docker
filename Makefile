build:
	@ docker build -t idempiere:7.1 -t idempiere:latest .

bash:
	@ docker run -it --rm idempiere:7.1 bash

run:
	@ docker stack deploy -c docker-stack.yml idempiere

stop:
	@ docker stack rm idempiere

log:
	@ docker service logs -f idempiere_idempiere

clean:
	@ docker volume rm idempiere_idempiere_data || true
	@ docker volume rm idempiere_idempiere_plugins || true
	@ docker volume rm idempiere_idempiere_config || true
