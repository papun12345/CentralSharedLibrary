#!/usr/bin/env groovy
def call(docker,command) {
  echo "************************************Run Build Inside Container**************************************"
  def dockerImage=docker
  def mavenCommand=command
  docker.image(dockerImage).inside(){
	sh mavenCommand
}
}
//"subhasanket/java-maven-node-env"
//"mvn clean package"
