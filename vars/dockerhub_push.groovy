def call(String dockerHubUser, String imageName, String imageTag) {
    withCredentials([usernamePassword(credentialsId: "dockerHubCred", usernameVariable: "dockerHubUser", passwordVariable: "dockerHubPass")]) {
        sh """
            echo "\$dockerHubPass" | docker login -u "\$dockerHubUser" --password-stdin
        """
    }
    sh "docker push \$dockerHubUser/\$imageName:\$imageTag"
}
