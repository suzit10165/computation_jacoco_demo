pipeline {
    agent any

    tools {
        jdk 'jdk17'
        maven 'Maven 3'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn -B clean test jacoco:report'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
            recordCoverage(
                tools: [jacoco(pattern: 'target/site/jacoco/jacoco.xml')],
                sourceCodeRetention: 'NEVER',
                qualityGates: [[threshold: 95, metric: 'LINE', buildResult: 'FAILURE']]
            )
        }
    }
}
