def call(String url='mylearnings', String branch='mybranch') {

  git branch: ${branch}, url: ${url}
             
}
