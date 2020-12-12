# Development Mode


#### Using Makefile to Create from Dockerfile

```
$ make build run
```

Command list:

`make build` creates iDempiere docker image (with labels `idempiere:8.1` and `idempiere:latest`)

`make run` runs iDempiere docker stack (includes `postgres:12`)

`make stop` stops the stack

`make log` shows the logs of iDempiere

`make bash` creates a terminal within iDempiere docker image
