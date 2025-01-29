// Define function
def call(String dockerHubUserName, String imageName, String imageTag){
  sh "docker build -t ${dockerHubUserName}/${imageName}:${imageTag} ."
}