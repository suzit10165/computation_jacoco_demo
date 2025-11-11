pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }
    stage('Build & Test') {
      steps { bat 'mvn -B clean test jacoco:report' }
    }
  }

  post {
    always {
      junit 'target/surefire-reports/*.xml'
      publishCoverage(
        adapters: [jacocoAdapter('target/site/jacoco/jacoco.xml')],
        sourceCodeRetention: 'NEVER',
        qualityGates: [[threshold: 95, metric: 'LINE', buildResult: 'FAILURE']]
      )
    }
  }
}
