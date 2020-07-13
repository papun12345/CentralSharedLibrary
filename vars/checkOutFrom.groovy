#!/usr/bin/groovy
def call() {
  echo "************************************CheckOut**************************************"
  checkout([
    		$class: 'GitSCM', 
            branches: [[name: '*/master']],
            doGenerateSubmoduleConfigurations: false,
            extensions: [[$class: 'CleanBeforeCheckout']],
            submoduleCfg: [], 
            userRemoteConfigs: [[credentialsId: "${env.scmCredential}", url: "${env.scmUrl}"]]
  ])
}
