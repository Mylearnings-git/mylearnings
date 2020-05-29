@Library('Mysharedlib') _
def loadValuesYaml(){
def valuesYaml = readYaml (file: 'config1.yml')
 return valuesYaml;
 }
def codecoverageYaml()  {
 def coverageyaml = readYaml (file: 'coverage.yml')
    return coverageyaml;
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
     coverageyaml = codecoverageYaml()
     //println valuesYaml.getClass()
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
                        
     sonar(valuesYaml.Toolname.tool, valuesYaml.Toolname.envname)
                          
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
    code(coverageyaml.Coverage.class, coverageyaml.Coverage.execPattern, coverageyaml.Coverage.classPattern, coverageyaml.Coverage.sourcePattern, coverageyaml.Coverage.exclusionPattern)
        
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
