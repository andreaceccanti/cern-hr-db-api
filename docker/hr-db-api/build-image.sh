#!/bin/bash
#
# Copyright (c) Istituto Nazionale di Fisica Nucleare (INFN). 2016-2020
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

set -ex
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}"  )" && pwd  )"

JAR_NAME=hr-db-api

if [[ -z ${JAR} ]]; then
  for f in ${DIR}/../../target/${JAR_NAME}-*.jar; do
    JAR=${f}
    break
  done
fi

if [[ ! -r ${JAR} ]]; then
  echo "Please set the JAR env variable so that it points to a jar location"
  exit 1
fi

echo "Building image using jar from ${JAR}"

cp ${JAR} ${JAR_NAME}.jar
build-docker-image.sh
rm ${JAR_NAME}.jar
