pipeline {
    agent any

    environment {
        COMPOSE_FILE = 'docker-compose.yaml'
    }

    stages {
        stage('Clone Repo') {
            steps {
                git 'https://github.com/charandevini/decentralizedlearningplatform.git' // Change to your Git repo
            }
        }

        stage('Build Images') {
            steps {
                sh 'docker compose build'
            }
        }

        stage('Stop Running Services') {
            steps {
                sh 'docker compose down'
            }
        }

        stage('Deploy Microservices') {
            steps {
                sh 'docker compose up -d'
            }
        }
    }

    post {
        success {
            echo '✅ Deployment completed successfully!'
        }
        failure {
            echo '❌ Deployment failed!'
        }
    }
}
