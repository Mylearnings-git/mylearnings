@Library('Mysharedlib') _
//import static org.foo.GlobalVars.*
import groovy.json.JsonSlurper
//import groovy.json.JsonSlurperClassic
//import groovy.json.JsonOutput
def filename = '/var/lib/jenkins/workspace/mysharedlib/Projects.json'
def JsonSlurper = new JsonSlurper()
data = JsonSlurper.parse(new File(filename))
println(data)
pipeline
{
 
 agent any
  stages {
   stage('checkout'){
    steps {
      echo "hello"
                // println(data.jenkinfile.Gitcred.url)
         //def data = new JsonSlurperClassic().parseText(projects)
      //myDeliveryPipeline(branch: 'data.jenkinfile.Gitcredential.branch', scmUrl: 'data.jenkinfile.Gitcredential.url')
      //myDeliveryPipeline(branch: 'master', scmUrl: 'https://github.com/Mylearnings-git/mylearnings.git')
      // myDeliveryPipeline(branch: 'master', scmUrl: 'GlobalVars.url')
       
       // myDeliveryPipeline('master', 'https://github.com/Mylearnings-git/mylearnings.git')
      
     //
     //
     //Println(data)
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
