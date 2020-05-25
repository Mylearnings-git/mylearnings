@Library('Mysharedlib') _
import groovy.json.*
import hudson.model.*
import groovy.json.JsonSlurperClassic
//def datas = readYaml file: "/var/lib/jenkins/workspace/mysharedlib/source.yml"
//def filename = '/var/lib/jenkins/workspace/mysharedlib/Projects.json'
//jsonSlurper = new JsonSlurperClassic()
//def data = jsonSlurper.parse(new File(filename))
//println(data)
pipeline
{
 agent any
 
 environment
 {
  def datas = readYaml file: "/var/lib/jenkins/workspace/mysharedlib/source.yml"
 }
//def filename = '/var/lib/jenkins/workspace/mysharedlib/Projects.json'
//jsonSlurper = new JsonSlurper()
//def data = jsonSlurper.parse(new File(filename))
//println(data)
 //}
 stage ('deployment')
    {
      steps {
       println "${datas}"
      }
    }
   
   stages {
    stage('checkout') {
    steps {
                        // println(data.jenkinfile.Gitcred.url)
         //def data = new JsonSlurperClassic().parseText(projects)
      //myDeliveryPipeline(branch: 'data.jenkinfile.Gitcredential.branch', scmUrl: 'data.jenkinfile.Gitcredential.url')
    myDeliveryPipeline(branch: 'master', scmUrl: 'https://github.com/Mylearnings-git/mylearnings.git')
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
            credentialsId: "Docker",
            usernameVariable: "Username",
            passwordVariable: "Password"
    )]) {
        
      // Dockbuild('data.jenkinfile.Gitcredential.branch', 'data.jenkinfile.Gitcredential.url')
      Dockbuild('restapi', 'yuvarajkumar', 'myrestapiapp')
        }
      }
    }
    stage ('Kuberneted deployment')
    {
      steps {
        withCredentials([[
 $class: 'AmazonWebServicesCredentialsBinding', 
 accessKeyVariable: 'AWS_ACCESS_KEY_ID', 
 credentialsId: 'e261da0d-0895-4f7d-953f-28dbf1f27f1c', 
 secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) 
 {
        kub('restapi1', 'us-west-2')
      }
      }
    }
   
  
    
  }
}
