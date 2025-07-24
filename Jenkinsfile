pipeline {
    agent any

    environment {
        COMPOSE_PROJECT_NAME = 'dlp'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git url: 'git@github.com:charandevini/decentralizedlearningplatform.git', branch: 'main'
            }
        }

        stage('Stop Existing Containers') {
            steps {
                script {
                    sh 'docker-compose down || true'
                }
            }
        }

        stage('Deploy Microservices') {
            steps {
                script {
                    sh 'docker-compose up -d --build'
                }
            }
        }

        stage('Check Running Containers') {
            steps {
                sh 'docker ps'
            }
        }
    }

    post {
        failure {
            echo '❌ Deployment failed!'
        }
        success {
            echo '✅ Microservices deployed successfully!'
        }
    }
}
