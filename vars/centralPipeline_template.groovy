#!/usr/bin/env groovy
def call(){
        def scmUrl = null
        def scmCredential = null
        getAllDetails()
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
                         checkOutFrom(scmUrl,scmCredential)
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
                          scmUrl = props['scmUrl']
                          scmCredential = props['scmCredential']  
                    }
           }
}
