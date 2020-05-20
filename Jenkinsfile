@Library('Mysharedlib') _
//import static org.foo.GlobalVars.*
import groovy.json.JsonSlurper
import groovy.json.JsonOutput
def filename = '$workspace/Projects.json'
def jsonSlurper = new JsonSlurper()
data = jsonSlurper.parse(new File(filename))
pipeline
{
 
                
                
   //def inputfile = readFile('Projects.json')
     //   def fileContents = new File(inputFile).getText('UTF-8')
     //  def jsonSlurper = new JsonSlurper()
     //  def jsonObject = jsonSlurper.parseText(fileContents)
                
agent any
  stages {
   stage('checkout'){
     steps {
                // println(data.jenkinfile.Gitcred.url)
         //def data = new JsonSlurperClassic().parseText(projects)
      myDeliveryPipeline(branch: 'data.jenkinfile.Gitcred.branch', scmUrl: 'data.jenkinfile.Gitcred.url')
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
