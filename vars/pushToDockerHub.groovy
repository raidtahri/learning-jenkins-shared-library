#!/usr/bin/env groovy
def call(String imageName, String imageTag) {

withCredentials([usernamePassword(
                    credentialsId: 'dockerhub',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    echo 'Pushing Docker Image to Docker Hub'
                    sh """
                        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                        docker push ${DOCKER_USER}/${imageName}:${imageTag}
                        docker logout
                    """
                }
}
