def call()
{
import groovy.json.JsonSlurper
def filename = '/var/lib/jenkins/workspace/mysharedlib/Projects.json'
def JsonSlurper = new JsonSlurper()
data = JsonSlurper.parse(new File(filename))
println(data)
}
