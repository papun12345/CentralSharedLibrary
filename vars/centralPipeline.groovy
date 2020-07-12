def call(jobName,repoUrl){
pipelineJob(jobName) {
        definition {
        cps {
            script('''echo "Hello ${repoUrl}"''')
            sandbox()
        }
    }
    }
}
