FROM centos:7

USER root

ENV HR_USER springboot
ENV HR_JAR /hr/hr-db-api.jar 

RUN mkdir -p /hr

COPY hr-db-api.jar /hr/hr-db-api.jar

RUN yum install -y java-1.8.0-openjdk java-1.8.0-openjdk-devel \
      && echo "securerandom.source=file:/dev/urandom" >> /usr/lib/jvm/java/jre/lib/security/java.security \ 
      && yum clean all

ENV JAVA_HOME /etc/alternatives/jre

RUN groupadd -r $HR_USER -g 1000 \
      && useradd -u 1000 -r -g $HR_USER -m -d /opt/$HR_USER -s /sbin/nologin $HR_USER \
      && chmod 755 /opt/$HR_USER \
      && chown -R $HR_USER /hr \
      && usermod -g root -G `id -g $HR_USER` $HR_USER \
      && chmod -R "g+rwX" /hr \
      && chown -R $HR_USER:root /hr


CMD java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap ${HR_JAVA_OPTS} -jar ${HR_JAR}

# Embed TINI since compose v3 syntax do not support the init 
# option to run docker --init
#
ENV TINI_VERSION v0.18.0
ADD https://github.com/krallin/tini/releases/download/${TINI_VERSION}/tini /tini
RUN chmod +x /tini
ENTRYPOINT ["/tini", "--"]

WORKDIR /hr
USER $HR_USER
