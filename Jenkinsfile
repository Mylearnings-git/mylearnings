@Library('Mysharedlib') _
pipeline
{
agent any
  stages {
    stage('checkout'){
      steps {
         def projects = readJSON file: 'Projects.json'
     myDeliveryPipeline(branch: 'projects.jenkinfile.Gitcredential[1].branch', scmUrl: 'projects.jenkinfile.Gitcredential[1].url')
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
