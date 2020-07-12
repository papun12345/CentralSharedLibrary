#!/usr/bin/groovy
def call(jobName,repoUrl){
jobDsl(jobName) {
        definition {
        cps {
            script('''echo "Hello ${repoUrl}"''')
            sandbox()
        }
    }
    }
}
