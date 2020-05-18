def call(Map project, Map hubUser) {
    
    pipeline {
        agent any
        stages {
            stage('Build docker git') {
                steps {
    sh "docker image build -t hubUser.user/project.name:beta-${env.BRANCH_NAME}-${env.BUILD_NUMBER} ."
    withCredentials([usernamePassword(
            credentialsId: "Docker",
            usernameVariable: "Username",
            passwordVariable: "Password"
    )]) {
        sh "docker login -u '$Username' -p '$Password'"
    }
    sh "docker image push ${hubUser}/${project}:beta-${env.BRANCH_NAME}-${env.BUILD_NUMBER}"
}
            }}}}
