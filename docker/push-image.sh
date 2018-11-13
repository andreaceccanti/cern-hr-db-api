#!/bin/bash
IMAGE_NAME=indigoiam/hr-db-api

IMAGE=${IMAGE:-${IMAGE_NAME}}

if [[ -n ${DOCKER_REGISTRY_HOST} ]]; then
  docker tag ${IMAGE} ${DOCKER_REGISTRY_HOST}/${IMAGE}
  docker push ${DOCKER_REGISTRY_HOST}/${IMAGE}
else
  docker push ${IMAGE}
fi
