@Library('Mysharedlib') _
import org.yaml.snakeyaml.Yaml
import groovy.json.*
//jsonSlurper = new JsonSlurper()
//@NonCPS
import hudson.model.*
//def file = new File('/var/lib/jenkins/workspace/mysharedlib/config.yml')
//def config = yaml.load(file.text)
 pipeline
{
 agent any
 
 environment
 {
  def datas = readYaml file: "/var/lib/jenkins/workspace/mysharedlib/config.yml"

 // def filename = '/var/lib/jenkins/workspace/mysharedlib/Projects.json'
  //def data = jsonSlurper.parse(new File(filename))
 }
//def filename = '/var/lib/jenkins/workspace/mysharedlib/Projects.json'
//jsonSlurper = new JsonSlurper()
//def data = jsonSlurper.parse(new File(filename))
//println(data)
 //}
 
   
   stages {
    
    stage ('deployment')
    {
      steps {
       println "data ==> ${datas}"
       println(datas)
      // println("$datas.name}")
       //println "${datas.branch}"
       //assert datas.Gitcred.branch == "master"
      // assert datas.branch == "master"
      }
    }
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
