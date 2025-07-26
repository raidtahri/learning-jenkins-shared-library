#!/usr/bin/env groovy
def call() {

          dir('06-hello-maven-shared-library-pipeline') {
                echo 'Building the app with Maven'
                sh 'mvn clean package -DskipTests'
                }
       }

