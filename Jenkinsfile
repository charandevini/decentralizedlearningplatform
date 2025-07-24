pipeline {
    agent any

    environment {
        COMPOSE_FILE = 'docker-compose.yml'  // Set docker-compose file as an env var (optional)
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/charandevini/decentralizedlearningplatform.git'
            }
        }

        stage('Stop Running Containers') {
            steps {
                script {
                    // Only remove containers from this compose project
                    sh '''
                        echo "🛑 Stopping existing containers..."
                        docker-compose down || true
                    '''
                }
            }
        }

        stage('Build & Start Services') {
            steps {
                script {
                    sh '''
                        echo "⚙️ Building and starting services..."
                        docker-compose up -d --build
                    '''
                }
            }
        }
    }

    post {
        success {
            echo '✅ Local deployment successful!'
        }
        failure {
            echo '❌ Deployment failed!'
        }
    }
}
