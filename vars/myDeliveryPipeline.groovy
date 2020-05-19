//def call(Map pipelineParams) {
 def call(Map yuvaparam) { 
  
  //git branch: pipelineParams.branch, url: pipelineParams.scmUrl
   
   git branch: yuvaparam.branch, url: yuvaparam.scmUrl

  //git branch: ${branch}, url: ${url}
             
}
