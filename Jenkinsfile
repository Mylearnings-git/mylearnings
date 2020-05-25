@Library('Mysharedlib') _
import org.yaml.snakeyaml.Yaml
//import jenkins.model.*
//jenkins = Jenkins.instance
import groovy.json.*
//jsonSlurper = new JsonSlurper()
//@NonCPS
//import hudson.model.*
//def datas = readYaml file: "/var/lib/jenkins/workspace/mysharedlib/config.yml"
//def file = new File('/var/lib/jenkins/workspace/mysharedlib/config.yml')
//def config = yaml.load(file.text)
 def loadValuesYaml(){
  def valuesYaml = readYaml (file: '/var/lib/jenkins/workspace/mysharedlib/config.yml')
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
       //println "data ==> ${datas}"
       //println(datas[0].value)
      // println("$datas.name}")
       //println "${datas.branch}"
       //assert datas.Gitcred.branch == "master"
      // assert datas.branch == "master"
      }
    }
    }
    stage('checkout') {
    steps {
     echo valuesYaml.repo
                        // println(data.jenkinfile.Gitcred.url)
         //def data = new JsonSlurperClassic().parseText(projects)
      //myDeliveryPipeline(branch: 'data.jenkinfile.Gitcredential.branch', scmUrl: 'data.jenkinfile.Gitcredential.url')
   myDeliveryPipeline(branch: valuesYaml.branch, scmUrl: valuesYaml.repo)
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
 credentialsId: 'e261da0d-0895-4f7d-953f-28dbf1f27f1c', 
 secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) 
 {
        kub(valuesYaml.kubcluster, valuesYaml.kubloc)
      }
      }
    }
   
  
    
  }
}
