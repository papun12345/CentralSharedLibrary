def CreatePipeline(){
        pipeline {
            agent any
            stages {
                stage('CleanUp'){
                    steps{
                        deleteDir()
                    }
                }
                stage('Check-Out'){
                    steps{
                         checkOutFrom('http://nitin@ec2-18-224-68-30.us-east-2.compute.amazonaws.com:7990/scm/sub/maven-project-sample.git','wipro-bitbucket')
                    }
                }
                stage('Run-Build-Inside-container'){
                    steps{
                                 dockerScript()
                    }
                }
                stage('Sonar-Scanning'){
                    steps{
                        sonarScanning()
                    }
                }
                stage('CodeCovrage-Check'){
                    steps{
                        codeCovrageCheck()
                    }
                }
            }
        }
    }
