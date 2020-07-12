#!/usr/bin/env groovy
def call() {
  echo "************************************Run Build Inside Container**************************************"
  echo "This is invoking with $dockerImage $mavenCommand"
	docker.image("${env.dockerImage}").inside(){
		sh "${env.mavenCommand}"
	}
}
