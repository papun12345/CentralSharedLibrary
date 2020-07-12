#!/usr/bin/env groovy
def call() {
  echo "************************************Run Build Inside Container**************************************"
  echo "This is invoking with $dockerImage $mavenCommand"
  //def dockerImage=docker
  //def mavenCommand=command
 // docker.image(dockerImage).inside(){
//	sh mavenCommand
//}
}
//"subhasanket/java-maven-node-env"
//"mvn clean package"
