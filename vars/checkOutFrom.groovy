#!/usr/bin/groovy
def call(url,credentialId) {
  echo "************************************CheckOut**************************************"
  def scmUrl=url
  def scmCredential=credentialId
  checkout([
    		$class: 'GitSCM', 
            branches: [[name: '*/master']],
            doGenerateSubmoduleConfigurations: false,
            extensions: [[$class: 'CleanBeforeCheckout']],
            submoduleCfg: [], 
            userRemoteConfigs: [[credentialsId: scmCredential, url: scmUrl]]
  ])
}
