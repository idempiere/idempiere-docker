FROM maven:3.9.6-eclipse-temurin-17

LABEL maintainer="orlando.curieles@ingeint.com"

ENV SOURCE_PATH /source
WORKDIR $SOURCE_PATH

ENV IDEMPIERE_BRANCH release-11
ENV SCAFFOLD_BRANCH 11.0
ENV TARGET_PLATFORM_BRANCH 11.0

ENV IDEMPIERE_REPOSITORY $SOURCE_PATH/idempiere
ENV SCAFFOLD_REPOSITORY $SOURCE_PATH/idempiere-plugin-scaffold
ENV TARGET_PLATFORM_REPOSITORY $SOURCE_PATH/idempiere-target-platform-plugin

RUN apt-get update && apt-get install -y --no-install-recommends make wget && \
    rm -rf /var/lib/apt/lists/*

RUN git clone --depth 1 https://github.com/idempiere/idempiere.git \
    --branch $IDEMPIERE_BRANCH --single-branch $IDEMPIERE_REPOSITORY && \
    cd $IDEMPIERE_REPOSITORY && \
    mvn verify -U

RUN git clone --depth 1 https://github.com/ingeint/idempiere-target-platform-plugin.git \
    --branch $TARGET_PLATFORM_BRANCH --single-branch $TARGET_PLATFORM_REPOSITORY

RUN git clone --depth 1 https://github.com/ingeint/idempiere-plugin-scaffold.git \
    --branch $SCAFFOLD_BRANCH --single-branch $SCAFFOLD_REPOSITORY

RUN cd $TARGET_PLATFORM_REPOSITORY && \
    ./plugin-builder ../idempiere-plugin-scaffold/plugin-example/com.ingeint.example \
    ../idempiere-plugin-scaffold/plugin-example/com.ingeint.example.test

ENTRYPOINT []
