def call(String codeclass, String pattern, String classptrn, String srcpatrn, String excpatrn) {
 step([$class: "${codeclass}", 
           execPattern: "${pattern}",
           classPattern: "${classptrn}",
           sourcePattern: "${srcpatrn}",
           exclusionPattern: "${excpatrn}"
           ])
}
