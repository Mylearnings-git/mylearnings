def call(String project, String hubUser string image) {
    sh "docker image build -t ${hubUser}/${project}:${image}-${env.BUILD_NUMBER} ."
   // withCredentials([usernamePassword(
          //  credentialsId: "Docker",
         //   usernameVariable: "Username",
          //  passwordVariable: "Password"
  //  )]) {
        sh "docker login -u '$Username' -p '$Password'"
   // }
    sh "docker image push ${hubUser}/${project}:${image}-${env.BUILD_NUMBER}"
}
