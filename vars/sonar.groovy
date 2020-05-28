def call(String toolname, String envname) {
  
  withSonarQubeEnv("${envname}") {

                            sh "${tool("${toolname}")}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
}
}
