def call(String class1, String execPattern, String classPattern, String sourcePattern, String exclusionPattern) {
step([$class: ${class1},
           execPattern: ${execPattern},
           classPattern: ${classPattern},
           sourcePattern: ${sourcePattern},
           exclusionPattern: ${exclusionPattern}
           ])
}           
                 
           
