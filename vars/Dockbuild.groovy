def call(String project, String hubUser, String image, String cred) {
   sh "docker image build -t ${hubUser}/${project}:${image}-${env.BUILD_NUMBER} ."
  withCredentials([usernamePassword(
    credentialsId: "${cred}",
            usernameVariable: "Username",
           passwordVariable: "Password"
    )]) {
        
        sh "docker login -u '$Username' -p '$Password'"
    }
    sh "docker image push ${hubUser}/${project}:${image}-${env.BUILD_NUMBER}"
}

