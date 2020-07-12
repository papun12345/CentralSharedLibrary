pipelineJob('DSL_Pipeline')  {
        definition {
        cps {
            script('''echo "Hello ${repoUrl}"''')
            sandbox()
        }
    }
}
