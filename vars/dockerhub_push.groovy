def call(String dockerHubUser, String imageName, String imageTag) {
    withCredentials([usernamePassword(credentialsId: "dockerhub-cred", usernameVariable: "dockerHubUser", passwordVariable: "dockerHubPass")]) {
        sh """
            echo "\$dockerHubPass" | docker login -u "\$dockerHubUser" --password-stdin
        """
    }
    sh "docker push \$dockerHubUser/\$imageName:\$imageTag"
}
