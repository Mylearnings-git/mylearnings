def call() {
def scannerHome = tool 'Mysonarscanner';
                          withSonarQubeEnv("Mysonar") {

                          sh "${tool("Mysonarscanner")}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
}
