# Development Mode

### Command list (valid parameter: `DOCKER_TAG`):

`make build` creates iDempiere docker image with tag `idempiere:daily`

`make up` runs iDempiere, includes `postgres:12` and `idempiere:daily`

`make down` stops iDempiere

`make bash` creates a terminal within iDempiere docker image

`make compose-up` runs iDempiere docker stack

`make compose-down` stops iDempiere docker stack

### Example using parameter `DOCKER_TAG` (all make commands support this argument):

`make build DOCKER_TAG=8.2` creates iDempiere docker image with tag `idempiere:8.2`

`make compose-up DOCKER_REPOSITORY=idempiereofficial/idempiere DOCKER_TAG=8.2` runs iDempiere's stack with tag `idempiereofficial/idempiere:8.2`
