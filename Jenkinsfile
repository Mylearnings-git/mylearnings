@Library('Mysharedlib') _
pipeline
{
agent any
  stages {
    stage('checkout'){
      steps {
         def projects = readJSON file: "${env.WORKSPACE}\\Projects.json"
     myDeliveryPipeline(branch: 'Projects.jenkinfile.Gitcredential[1].branch', scmUrl: 'Projects.jenkinfile.Gitcredential[1].url')
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
