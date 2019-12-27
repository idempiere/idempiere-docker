FROM openjdk:11-jdk

LABEL maintainer="saul.pina@ingeint.com"

ENV IDEMPIERE_VERSION 7.1
ENV IDEMPIERE_HOME /opt/idempiere
ENV IDEMPIERE_PLUGINS_HOME $IDEMPIERE_HOME/plugins
ENV IDEMPIERE_LOGS_HOME $IDEMPIERE_HOME/log

WORKDIR $IDEMPIERE_HOME

RUN apt-get update && \
    apt-get install -y --no-install-recommends postgresql-client && \
    rm -rf /var/lib/apt/lists/*

RUN wget -q "https://ufpr.dl.sourceforge.net/project/idempiere/v${IDEMPIERE_VERSION}/daily-server/idempiereServer${IDEMPIERE_VERSION}Daily.gtk.linux.x86_64.zip" -O /tmp/idempiere-server.zip && \
    unzip -q -o /tmp/idempiere-server.zip -d /tmp && \
    mv /tmp/idempiere.gtk.linux.x86_64/idempiere-server/* $IDEMPIERE_HOME && \
    rm -rf /tmp/idempiere*
RUN ln -s $IDEMPIERE_HOME/idempiere-server.sh /usr/bin/idempiere

COPY docker-entrypoint.sh $IDEMPIERE_HOME
COPY idempiere-server.sh $IDEMPIERE_HOME

ENTRYPOINT ["./docker-entrypoint.sh"]
CMD ["idempiere"]
