#!/usr/bin/env groovy
def call() {
  echo "************************************Run Build Inside Container**************************************"
  echo "This is invoking with $dockerImage $mavenCommand"
  docker.image($dockerImage).inside(){
	  sh $mavenCommand
}
}
//"subhasanket/java-maven-node-env"
//"mvn clean package"
