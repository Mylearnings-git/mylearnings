@Library('Mysharedlib') _
//import groovy.json.JsonSlurperClassic
pipeline
{
agent any
  stages {
   stage('checkout'){
     steps {
         //ef projects = readJSON file: 'Projects.json'
         //def data = new JsonSlurperClassic().parseText(projects)
      myDeliveryPipeline(branch: 'master', scmUrl: 'https://github.com/Mylearnings-git/mylearnings.git')
       //myDeliveryPipeline(branch: 'master', scmUrl: 'GlobalVars.url')
       
       // myDeliveryPipeline('master', 'https://github.com/Mylearnings-git/mylearnings.git')
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
    
     stage ('Docker build')
    {
      steps {
        
        Dockbuild('restapi', 'yuvarajkumar')
      }
    }
    stage ('Kuberneted deployment')
    {
      steps {
        
        kub('restapi1', 'us-west-2')
      }
    }
    
  }
}
