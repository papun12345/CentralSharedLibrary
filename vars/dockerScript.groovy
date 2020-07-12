#!/usr/bin/env groovy
def call(dockerImage,mavenCommand) {
  echo "************************************Run Build Inside Container**************************************"
  def dockerImage=dockerImage
  def mavenCommand=mavenCommand
  docker.image(dockerImage).inside(){
	sh mavenCommand
}
}
//"subhasanket/java-maven-node-env"
//"mvn clean package"
