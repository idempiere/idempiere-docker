FROM maven:3.6-jdk-11

LABEL maintainer="orlando.curieles@ingeint.com"

ENV IDEMPIERE_BRANCH release-10
ENV SCAFFOLD_BRANCH 10.0

ENV SOURCE_PATH /source
WORKDIR $SOURCE_PATH

ENV IDEMPIERE_REPOSITORY $SOURCE_PATH/idempiere
ENV SCAFFOLD_REPOSITORY $SOURCE_PATH/idempiere-plugin-scaffold

RUN apt-get update && apt-get install -y --no-install-recommends make wget && \
    rm -rf /var/lib/apt/lists/*
RUN git clone --depth 1 https://github.com/idempiere/idempiere.git --branch $IDEMPIERE_BRANCH --single-branch $IDEMPIERE_REPOSITORY && \
    cd $IDEMPIERE_REPOSITORY && \
    mvn verify -U
RUN git clone --depth 1 https://github.com/ingeint/idempiere-plugin-scaffold.git --branch $SCAFFOLD_BRANCH --single-branch $SCAFFOLD_REPOSITORY && \
    cd $SCAFFOLD_REPOSITORY/idempiere-plugin-template  && \
    ./build
