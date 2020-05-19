def call(Map pipelineParams) {

                    git branch: pipelineParams.branch, url: pipelineParams.scmUrl
             
}
