#!/usr/bin/env groovy

def call() {
  echo "************************************Run Build Inside Container**************************************"
  docker.image("subhasanket/java-maven-node-env").inside(){
	sh "mvn clean package"
}
}
