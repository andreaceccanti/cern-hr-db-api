FROM centos:7

ARG ORACLE_INSTANTCLIENT_PACKAGE=oracle-instantclient18.5-basic

RUN --mount=type=secret,id=oracle-repo-config cat \
      cat /run/secrets/oracle-repo-config > /etc/yum.repos.d/oracle-cnaf.repo

RUN yum -y install $ORACLE_INSTANTCLIENT_PACKAGE && yum clean all && \
  rm -vf /etc/yum.repos.d/oracle-cnaf.repo && yum -y update && yum clean all
