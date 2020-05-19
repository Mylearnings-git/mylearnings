@Library('Mysharedlib') _
//import static org.foo.GlobalVars.*
import groovy.json.JsonSlurper
import groovy.json.JsonOutput
pipeline
{
agent any
  stages {
   stage('checkout'){
     steps {
         string inputfile = 'Projects.json'
         string fileContents = new File(inputFile).getText('UTF-8')
       def jsonSlurper = new JsonSlurper()
       def jsonObject = jsonSlurper.parseText(fileContents)
         //def data = new JsonSlurperClassic().parseText(projects)
      myDeliveryPipeline(branch: 'jsonObject.jenkinfile.Gitcredential.branch', scmUrl: 'jsonObject.jenkinfile.Gitcredential.url')
      // myDeliveryPipeline(branch: 'master', scmUrl: 'GlobalVars.url')
       
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
