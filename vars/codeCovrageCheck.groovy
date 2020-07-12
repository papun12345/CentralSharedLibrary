#!/usr/bin/groovy
def call() {
  echo "************************************CodeCovrage-Check**************************************"
   timeout(time: 4, unit: 'MINUTES') {
      waitForQualityGate abortPipeline: true
    }
}
