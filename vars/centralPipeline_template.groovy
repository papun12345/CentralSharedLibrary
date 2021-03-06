#!/usr/bin/env groovy
def call(){
        pipeline {
            agent any
            stages {
                stage('CleanUp'){
                    steps{
                        deleteDir()
                    }
                }
                stage('LoadVariables'){
                    steps{
                        getAllDetails()
                    }
                }
                stage('Check-Out'){
                    steps{
                            checkOutFrom()
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
def getAllDetails(){
        configFileProvider([configFile(fileId: 'e8a0ea8b-f97a-4bd5-8f49-285c554d733f', variable: 'myCustom')]) {
                    script{ 
                          def props = readProperties file: "$myCustom"
                          env.scmUrl = props['scmUrl']
                          env.scmCredential = props['scmCredential']
                          env.dockerImage=props['dockerImage']
                          env.mavenCommand=props['mavenCommand']
                          env.sonarOrganization=props['sonarOrganization']
                          env.sonarProjectKey=props['sonarProjectKey']
                          env.sonarProjectName=props['sonarProjectName']
                         // echo "This is invoking with ${dockerImage} ${mavenCommand}"
                    }
           }
}
