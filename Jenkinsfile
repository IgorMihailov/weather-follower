pipeline {
    agent any
  environment {
    MAVEN_ARGS = " -e clean install"
  }
  stages {
    stage('Build') {
       steps {
            bat "./mvnw clean install"
       }
    }
  }
}