FROM openjdk:11-jdk

LABEL maintainer="orlando.curieles@ingeint.com"

ENV IDEMPIERE_VERSION 7.1
ENV IDEMPIERE_HOME /opt/idempiere
ENV IDEMPIERE_PLUGINS_HOME $IDEMPIERE_HOME/plugins
ENV IDEMPIERE_LOGS_HOME $IDEMPIERE_HOME/log
ENV IDEMPIERE_BUILD https://jenkins.idempiere.org/job/iDempiere7.1/ws/org.idempiere.p2/target/products/org.adempiere.server.product/idempiereServer.gtk.linux.x86_64.zip

WORKDIR $IDEMPIERE_HOME

RUN apt-get update && \
    apt-get install -y --no-install-recommends nano postgresql-client && \
    rm -rf /var/lib/apt/lists/*

RUN wget -q $IDEMPIERE_BUILD -O /tmp/idempiere-server.zip && \
    echo "Hash: $(md5sum /tmp/idempiere-server.zip)" > $IDEMPIERE_HOME/MD5SUMS && \
    echo "Date: $(date)" >> $IDEMPIERE_HOME/MD5SUMS && \
    unzip -q -o /tmp/idempiere-server.zip -d /tmp && \
    mv /tmp/idempiere.gtk.linux.x86_64/idempiere-server/* $IDEMPIERE_HOME && \
    rm -rf /tmp/idempiere*
RUN cat $IDEMPIERE_HOME/MD5SUMS
RUN ln -s $IDEMPIERE_HOME/idempiere-server.sh /usr/bin/idempiere

COPY docker-entrypoint.sh $IDEMPIERE_HOME
COPY idempiere-server.sh $IDEMPIERE_HOME

ENTRYPOINT ["./docker-entrypoint.sh"]
CMD ["idempiere"]
