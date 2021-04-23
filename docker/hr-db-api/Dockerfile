FROM indigoiam/cern-hr-db-base

USER root

ENV HR_USER springboot
ENV HR_JAR /hr/hr-db-api.jar 

RUN mkdir -p /hr

RUN yum install -y java-11-openjdk-devel  \
      && yum clean all

ENV JAVA_HOME /etc/alternatives/jre

RUN groupadd -r $HR_USER -g 1000 \
      && useradd -u 1000 -r -g $HR_USER -m -d /opt/$HR_USER -s /sbin/nologin $HR_USER \
      && chmod 755 /opt/$HR_USER \
      && chown -R $HR_USER /hr \
      && usermod -g root -G `id -g $HR_USER` $HR_USER \
      && chmod -R "g+rwX" /hr \
      && chown -R $HR_USER:root /hr

CMD java ${HR_JAVA_OPTS} -jar ${HR_JAR}

COPY hr-db-api.jar /hr/hr-db-api.jar

ENV TINI_VERSION v0.19.0
ADD https://github.com/krallin/tini/releases/download/${TINI_VERSION}/tini /tini
RUN chmod +x /tini
ENTRYPOINT ["/tini", "--"]

WORKDIR /hr
USER $HR_USER
