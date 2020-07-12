pipelineJob(jobName) {
        definition {
        cps {
            script('''echo "Hello ${repoUrl}"''')
            sandbox()
        }
    }
    }
