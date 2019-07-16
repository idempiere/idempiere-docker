build:
	@ docker build -t idempiere:6.2 -t idempiere:latest .

bash:
	@ docker run -it --rm idempiere:6.2 bash

run:
	@ docker stack deploy -c docker-stack.yml idempiere

stop:
	@ docker stack rm idempiere

log:
	@ docker service logs -f idempiere_idempiere
