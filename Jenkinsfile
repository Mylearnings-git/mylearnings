@Library('Mysharedlib') _
def loadValuesYaml(){
def valuesYaml = readYaml (file: 'config.yml')
 return valuesYaml;
 }
 pipeline
{
 agent any
    stages {
    stage ('deployment')
    {
     steps {
     script {
     valuesYaml = loadValuesYaml()
     println valuesYaml.getClass()
     }
    }
  }
    stage('checkout') {
    steps {
     echo valuesYaml.repo
            myDeliveryPipeline(branch: valuesYaml.branch, scmUrl: valuesYaml.repo)
         }
    }
    stage('mvn build')
    {
      steps {
        mavenbuild()
      }
    }
    stage ('sonar analysis')
    {
      steps {
        
        sonar()
      }
    }
    
 stage('Junit')
   {
    steps{
     test()
    }
   }
   
     stage ('Docker build')
    {
      steps {
       
        withCredentials([usernamePassword(
            credentialsId: valuesYaml.dockercred,
            usernameVariable: "Username",
            passwordVariable: "Password"
    )]) {
        
      // Dockbuild('data.jenkinfile.Gitcredential.branch', 'data.jenkinfile.Gitcredential.url')
      Dockbuild(valuesYaml.dockerrepo, valuesYaml.dockeruser, valuesYaml.dockerimg)
        }
      }
    }
    stage ('Kuberneted deployment')
    {
      steps {
        withCredentials([[
 $class: 'AmazonWebServicesCredentialsBinding', 
 accessKeyVariable: 'AWS_ACCESS_KEY_ID', 
 credentialsId: valuesYaml.kubcred, 
 secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) 
 {
        kub(valuesYaml.kubcluster, valuesYaml.kubloc)
      }
      }
    }
    
  }
}
