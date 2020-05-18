def call() {
    
    pipeline {
        agent any
        stages {
            stage('Build maven') {
                steps {
    sh "mvn clean install"
                }}}}}
