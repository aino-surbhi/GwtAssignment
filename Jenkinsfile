pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Building'
        sh withMaven(globalMavenSettingsConfig: 'fd7b172f-ffa4-4113-b1d8-a255cc98ec38', publisherStrategy: 'EXPLICIT', maven: 'maven', 
                                  mavenSettingsConfig: 'e676c977-aae6-4d77-81ca-7766c648e39f') {
                                                                                                                        sh 'mvn -version'
                                                                                                                        sh 'mvn -U clean install -DskipTests'
                                                                                                                      }
        }
      }

      stage('Test') {
        steps {
          echo 'Testing'
        }
      }

      stage('Deploy') {
        steps {
          echo 'Deploying'
        }
      }

    }
  }