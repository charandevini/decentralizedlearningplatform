pipeline {
    agent any

    environment {
        COMPOSE_FILE = 'docker-compose.yaml'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/charandevini/decentralizedlearningplatform.git'
            }
        }

        stage('Stop Running Containers') {
            steps {
                sh '''
                    echo "🛑 Stopping old containers..."
                    docker-compose down || true

                    echo "🧹 Removing all containers..."
                    docker rm -f $(docker ps -aq) || true
                '''
            }
        }


        stage('Build & Deploy') {
            steps {
                sh '''
                    echo "⚙️ Building and deploying..."
                    docker-compose up -d --build
                '''
            }
        }
    }

    post {
        success {
            echo '✅ Deployment successful!'
        }
        failure {
            echo '❌ Deployment failed!'
        }
    }
}
