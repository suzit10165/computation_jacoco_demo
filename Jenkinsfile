pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }
    stage('Build & Test') {
      steps {
        bat 'mvn -B clean test jacoco:report'
      }
    }
  }

  post {
    always {
      // test results
      junit 'target/surefire-reports/*.xml'

      // JaCoCo via Coverage plugin + Quality Gate >= 95% LINE
      recordCoverage(
        tools: [[parser: 'JACOCO', pattern: 'target/site/jacoco/jacoco.xml']],
        sourceCodeRetention: 'NEVER',
        qualityGates: [[metric: 'LINE', threshold: 95, criticality: 'FAILURE']]
      )

      // keep the HTML so you can open it and screenshot
      archiveArtifacts artifacts: 'target/site/jacoco/**', fingerprint: true, allowEmptyArchive: true
    }
  }
}
