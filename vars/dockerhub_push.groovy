def call(String credentialsId, String imageName, String imageTag) {
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        sh """
            echo "\$DOCKER_PASS" | docker login -u "\$DOCKER_USER" --password-stdin
            docker push "\$DOCKER_USER/$imageName:$imageTag"
            docker logout
        """
    }
}
