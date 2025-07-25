#!usr/bin/env groovy
def call(String IMAGE_NAME, String IMAGE_TAG) {
          dir('06-hello-maven-shared-library-pipeline') {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    echo 'Building Docker Image'
                    sh "docker build -t ${DOCKER_USER}/${IMAGE_NAME}:${IMAGE_TAG} ."
                }
                }
}
