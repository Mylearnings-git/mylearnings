def call(String class, String execPattern, String classPattern, String sourcePattern, String exclusionPattern) 
{
step([$class: ${class},
            execPattern: ${execPattern},
           classPattern: ${classPattern},
           sourcePattern}: ${sourcePattern},
           exclusionPattern: ${exclusionPattern}
           ])
}
