def call(String imageName, String imageTag, String dockerhubuser) {
    withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]) {
        sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
    }
    sh "docker push ${dockerhubuser}/${imageName}:${imageTag}"
}