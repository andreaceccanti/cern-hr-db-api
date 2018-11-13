FROM openjdk:8

ENV HR_JAR /hr/hr-db-api.jar 

RUN mkdir -p /hr

WORKDIR /hr
COPY hr-db-api.jar /hr/hr-db-api.jar

CMD java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap ${HR_JAVA_OPTS} -jar ${HR_JAR}

# Embed TINI since compose v3 syntax do not support the init 
# option to run docker --init
#
ENV TINI_VERSION v0.18.0
ADD https://github.com/krallin/tini/releases/download/${TINI_VERSION}/tini /tini
RUN chmod +x /tini
ENTRYPOINT ["/tini", "--"]

