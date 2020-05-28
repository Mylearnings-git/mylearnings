@Library('Mysharedlib') _
def loadValuesYaml(){
def valuesYaml = readYaml (file: 'config1.yml')
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
     //println valuesYaml.getClass()
     
     }
    }
  }
    stage('checkout') {
     when {
                branch 'release'
     }
    steps {
     //echo valuesYaml.Maven.Goals(0)
     
     echo valuesYaml.Gitdetails.branch
            myDeliveryPipeline(branch: valuesYaml.Gitdetails.branch, scmUrl: valuesYaml.Gitdetails.repo)
     
      
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
       
                           echo valuesYaml.Toolname.tool
                           echo valuesYaml.Toolname.envname
       def scannerHome = tool valuesYaml.Toolname.too
        
     sonar(valuesYaml.Toolname.tool, valuesYaml.Toolname.envname)
                          


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
            credentialsId: valuesYaml.CredId.dockercred,
            usernameVariable: "Username",
            passwordVariable: "Password"
    )]) {
        
      // Dockbuild('data.jenkinfile.Gitcredential.branch', 'data.jenkinfile.Gitcredential.url')
      Dockbuild(valuesYaml.Dockerdetails.dockerrepo, valuesYaml.Dockerdetails.dockeruser, valuesYaml.Dockerdetails.dockerimg)
        }
      }
    }
    stage ('Kuberneted deployment')
    {
      steps {
        withCredentials([[
 $class: 'AmazonWebServicesCredentialsBinding', 
 accessKeyVariable: 'AWS_ACCESS_KEY_ID', 
 credentialsId: valuesYaml.CredId.kubcred, 
 secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) 
 {
        kub(valuesYaml.Kubdetails.kubcluster, valuesYaml.Kubdetails.kubloc)
      }
      }
    }
    
  }
}
