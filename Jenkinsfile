#!/usr/bin/env groovy
@Library('sd')_

def kubeLabel = getKubeLabel()

pipeline {

  agent any

  options {
    ansiColor('xterm')
    buildDiscarder(logRotator(numToKeepStr: '5'))
    skipDefaultCheckout()
    timeout(time: 1, unit: 'HOURS')
    timestamps()
  }

  parameters {
    booleanParam(name: 'SKIP_DOCKER', defaultValue: false, description: 'Skip docker image creation')
    booleanParam(name: 'PUSH_TO_DOCKERHUB', defaultValue: false, description: 'Push to Dockerhub')
  }

  triggers { cron('@daily') }

  environment {
    DOCKER_REGISTRY_HOST = "${env.DOCKER_REGISTRY_HOST}"
  }

  stages {

    stage('build, test, package'){
      agent {
        kubernetes {
          label "${kubeLabel}"
          cloud 'Kube mwdevel'
          defaultContainer 'runner'
          inheritFrom 'ci-template'
        }
      }

      stages {
        stage('checkout') {
          steps {
              deleteDir()
              checkout scm
              stash name: 'code', useDefaultExcludes: false
          }
        }

        stage('license-check') {
          steps {
              sh 'mvn license:check'
          }
        }

        stage('package') {
          steps {
            sh 'mvn package'
            archiveArtifacts 'target/hr-db-api-*.jar'
            stash includes: 'target/hr-db-api-*.jar', name: 'jars'
          }
        }
      }
    }

    stage('docker-images') {
      when{
        not {
          expression { return params.SKIP_DOCKER }
        }
      }

      agent {
        label "docker"
      }

      steps {
        deleteDir()
        unstash 'code'
        unstash 'jars'
        sh '''#!/bin/bash
        cd docker
        pwd
        build-image.sh
        push-docker-image.sh
        '''
        script {
          if (env.BRANCH_NAME == 'master' || params.PUSH_TO_DOCKERHUB ) {
            sh '''#!/bin/bash
            unset DOCKER_REGISTRY_HOST
            cd docker
            push-docker-image.sh
            '''
          }
        }
      }
    }
  }

  post {
    success {
      slackSend channel: "#iam", color: 'good', message: "${env.JOB_NAME} - #${env.BUILD_NUMBER} Success (<${env.BUILD_URL}|Open>)" 
    }

    unstable {
      slackSend channel: "#iam", color: 'danger', message: "${env.JOB_NAME} - #${env.BUILD_NUMBER} Unstable (<${env.BUILD_URL}|Open>)" 
    }

    failure {
      slackSend channel: "#iam", color: 'danger', message: "${env.JOB_NAME} - #${env.BUILD_NUMBER} Failure (<${env.BUILD_URL}|Open>)" 
    }
  }
}
