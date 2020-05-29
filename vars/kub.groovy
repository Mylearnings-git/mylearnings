 def call(String cluster, String region, String kubecred) {
  withCredentials([[
 $class: 'AmazonWebServicesCredentialsBinding', 
 accessKeyVariable: 'AWS_ACCESS_KEY_ID', 
 credentialsId: "${kubecred}", 
secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) 
 {
              echo "Login Successfull"
              sh "aws eks --region '${region}'  update-kubeconfig --name '${cluster}'"
              sh 'sed -i s/"Build_Number"/"$BUILD_NUMBER"/g deployment.yml'
              sh 'kubectl apply -f deployment.yml'
              sh 'kubectl apply -f service.yml'
             }
              }
