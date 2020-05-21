def call(String project, String hubUser) {
    sh "docker image build -t ${hubUser}/${project}:myrestapiapp-${env.BUILD_NUMBER} ."
   // withCredentials([usernamePassword(
          //  credentialsId: "Docker",
         //   usernameVariable: "Username",
          //  passwordVariable: "Password"
  //  )]) {
        sh "docker login -u '$Username' -p '$Password'"
   // }
    sh "docker image push ${hubUser}/${project}:myrestapiapp-${env.BUILD_NUMBER}"
}
