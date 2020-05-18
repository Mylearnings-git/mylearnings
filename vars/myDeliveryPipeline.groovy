def call(Map pipelineParams) {

    pipeline {
        agent any
        stages {
            stage('checkout git') {
                steps {
                    git branch: pipelineParams.branch, url: pipelineParams.scmUrl
                }
            }
            stage('mvn build')
                  {
             steps
                      {
                          sh 'mvn clean install'
                      }
                  }
}
}
}
