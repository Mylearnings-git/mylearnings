@Library('Mysharedlib') _
//import static org.foo.GlobalVars.*
//import groovy.json.JsonSlurper
//import jenkins.*
//import jenkins.model.*
//import hudson.*
//import hudson.model.*
//import groovy.json.JsonSlurper;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.List;
//import java.util.Map;
 //@NonCPS
import groovy.json.*

pipeline
{
 agent any

  {
   
    environment
 {
    
     def filename = '/var/lib/jenkins/workspace/mysharedlib/Projects.json'
def jsonSlurper = new JsonSlurper()
data = jsonSlurper.parse(new File(filename))
//println(data.jenkinfile.Gitcredential.branch)
 }
  stages {
   stage('checkout'){
    steps {
   
  
     // echo "hello"
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
    
     stage ('Docker build')
    {
      steps {
       
        withCredentials([usernamePassword(
            credentialsId: "Docker",
            usernameVariable: "Username",
            passwordVariable: "Password"
    )]) {
        
      // Dockbuild('data.jenkinfile.Gitcredential.branch', 'data.jenkinfile.Gitcredential.url')
      Dockbuild('restapi', 'yuvarajkumar')
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
   
   stage('one')
   {
    steps{
     
println(parsedJson)
    }
   }
   
   
    
  }
}
