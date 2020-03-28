FROM centos:7

ARG ORACLE_USER=test
ARG ORACLE_PASSWORD=test
ARG ORACLE_INSTANTCLIENT_PACKAGE=oracle-instantclient18.5-basic

ADD ./assets/oracle-cnaf.repo /etc/yum.repos.d/

RUN sed -i -e "s/%%%USERNAME%%%/"$ORACLE_USER"/" /etc/yum.repos.d/oracle-cnaf.repo
RUN sed -i -e "s/%%%PASSWORD%%%/"$ORACLE_PASSWORD"/" /etc/yum.repos.d/oracle-cnaf.repo

RUN yum -y install $ORACLE_INSTANTCLIENT_PACKAGE && yum clean all && \
  rm -vf /etc/yum.repos.d/oracle-cnaf.repo && yum -y update && yum clean all
