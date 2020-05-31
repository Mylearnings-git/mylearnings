def call(String toolname, String envname, String file) {
  //def scannerHome = tool 'Mysonarscanner'
  
  withSonarQubeEnv("${envname}") {

    sh "${tool("${toolname}")}/bin/sonar-scanner -Dproject.settings=${file}"
}
}
