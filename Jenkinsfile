@Library('Mysharedlib') _
pipeline
{
agent any
  stages {
    stage('checkout'){
      steps {
     myDeliveryPipeline(branch: 'master', scmUrl: 'https://github.com/Mylearnings-git/mylearnings.git')
      }
    }
    stage('mvn build')
    {
      steps {
        Dockerbuild
      }
    }
    
  }
