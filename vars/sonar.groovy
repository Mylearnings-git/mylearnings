def call(String toolname, String envname) {
  def scannerHome = tool '${toolname}'
  
  withSonarQubeEnv("${envname}") {

                            sh "${tool("${toolname}")}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
}
}
