pipeline {
    agent any
  environment {
    MAVEN_ARGS = " -e clean install"
    registry = ""
    dockerContainerName = 'weather_api'
    dockerImageName = 'weather_api_img'
  }
  stages {
    stage('Build') {
       steps {
            bat "mvn ${MAVEN_ARGS}"
       }
    }

 stage('clean container') {
      steps {
       bat 'docker ps -f name=${dockerContainerName} -q | xargs --no-run-if-empty docker container stop'
       bat 'docker container ls -a -fname=${dockerContainerName} -q | xargs -r docker container rm'
       bat 'docker images -q --filter=reference=${dockerImageName} | xargs --no-run-if-empty docker rmi -f'
      }
    }

  stage('docker-compose start') {
      steps {
       bat 'docker compose up -d'
      }
    }
  }
}