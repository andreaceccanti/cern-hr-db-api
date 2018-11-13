#!/bin/bash
set -ex
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}"  )" && pwd  )"

JAR_NAME=hr-db-api
IMAGE_NAME=indigoiam/hr-db-api

if [[ -z ${JAR} ]]; then
  for f in ${DIR}/../target/${JAR_NAME}-*.jar; do
    JAR=${f}
    break
  done
fi

if [[ ! -r ${JAR} ]]; then
  echo "Please set the JAR env variable so that it points to a jar location"
  exit 1
fi

echo "Building image using jar from ${JAR}"

IMAGE=${IMAGE:-${IMAGE_NAME}}

cd ${DIR}
cp ${JAR} ${JAR_NAME}.jar 

docker build --rm=true --no-cache -t ${IMAGE} .
rm ${JAR_NAME}.jar
