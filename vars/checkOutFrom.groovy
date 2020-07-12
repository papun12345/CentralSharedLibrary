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
  //'http://nitin@ec2-18-224-68-30.us-east-2.compute.amazonaws.com:7990/scm/sub/maven-project-sample.git'
  //'wipro-bitbucket'
}
