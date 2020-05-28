def call(String tool, String envname) {
def scannerHome = tool 'tool';
                          withSonarQubeEnv("envname") {

                          sh "${tool("tool")}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
}
