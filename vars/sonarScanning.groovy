#!/usr/bin/groovy
def call() {
  echo "************************************SonarCloud-Injection**************************************"
  def SCANNER_HOME = tool 'Sonar_Jenkins'
  //def SONAR_CREDENTIAL = credentials 'SonarCloud'
  withSonarQubeEnv(credentialsId: 'SonarCloud', installationName: 'SonarCloud') {
    sh "${SCANNER_HOME}/bin/sonar-scanner -Dsonar.organization=env.sonarOrganisation \
                -Dsonar.organization=env.sonarOrganisation \
                -Dsonar.projectKey=env.sonarProjectKey \
                -Dsonar.projectName=env.sonarProjectName \
                -Dsonar.projectVersion=1.0 \
                -Dsonar.sources=. \
                -Dsonar.language=java \
                -Dsonar.java.binaries=. \
                -Dsonar.java.coveragePlugin=jacoco \
                -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/*.xml \
                -Dsonar.exclusions=src/test/java/com/javatechie/StringPalindrome/AppTest.java \
                -Dsonar.sourceEncoding=UTF-8"
    }   
}
