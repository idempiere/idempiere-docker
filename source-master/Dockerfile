FROM maven:3.6-jdk-11

LABEL maintainer="orlando.curieles@ingeint.com"

ENV IDEMPIERE_BRANCH master
ENV IDEMPIERE_REPOSITORY /source/idempiere

RUN apt-get update && apt-get install -y --no-install-recommends make && \
    rm -rf /var/lib/apt/lists/* && \
    git clone --depth 1 https://github.com/idempiere/idempiere.git --branch $IDEMPIERE_BRANCH --single-branch $IDEMPIERE_REPOSITORY && \
    cd $IDEMPIERE_REPOSITORY && \
    mvn verify -U

WORKDIR $IDEMPIERE_REPOSITORY
