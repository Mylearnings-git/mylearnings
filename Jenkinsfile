@Library('Mysharedlib') _
import groovy.json.JsonSlurperClassic
pipeline
{
agent any
  stages {
    stage('checkout'){
      steps {
         def projects = readJSON file: 'Projects.json'
         def data = new JsonSlurperClassic().parseText(projects)
        myDeliveryPipeline(branch: '${data.jenkinfile.Gitcredential[1].branch}', scmUrl: '${data.jenkinfile.Gitcredential[1].url}')
      }
    }
    stage('mvn build')
    {
      steps {
        Dockerbuild()
      }
    }
    stage ('sonar analysis')
    {
      steps {
        
        sonar()
      }
    }
    
  }
}
