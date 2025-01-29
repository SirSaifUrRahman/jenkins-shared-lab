def call(String dockerHubUserName, String imageName, String imageTag){
   sh "docker rmi ${dockerHubUserName}/${imageName}:${imageTag} ."
}