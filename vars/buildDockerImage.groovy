#!/usr/bin/env groovy
def call(imageName, imageTag) {
          dir('06-hello-maven-shared-library-pipeline') {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    echo 'Building Docker Image'
                    sh "docker build -t ${DOCKER_USER}/${imageName}:${imageTag} ."
                }
                }
}
