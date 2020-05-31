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
     
         }
    }
  }
    stage('checkout') {
        steps {
     
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
                        
     sonar(valuesYaml.Toolname.tool, valuesYaml.Toolname.envname, valuesYaml.Toolname.file )
                          
              }
    }
    
 stage('Junit')
   {
    steps{
     test()
    }
   }
     
     stage('Publish Test Coverage Report') {
   steps {
    code(valuesYaml.Coverage.class, valuesYaml.Coverage.execPattern, valuesYaml.Coverage.classPattern, valuesYaml.Coverage.sourcePattern, valuesYaml.Coverage.exclusionPattern)
        
          }
      }
   
     stage ('Docker build')
    {
      steps {
       
     
      Dockbuild(valuesYaml.Dockerdetails.dockerrepo, valuesYaml.Dockerdetails.dockeruser, valuesYaml.Dockerdetails.dockerimg, valuesYaml.CredId.dockercred)
       }
    }
    stage ('Kuberneted deployment')
    {
      steps {
     
        kub(valuesYaml.Kubdetails.kubcluster, valuesYaml.Kubdetails.kubloc, valuesYaml.CredId.kubcred)
            }
    }
    
  }
}
