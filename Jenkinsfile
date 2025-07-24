pipeline {
    agent any

    environment {
        // Unique project name to avoid Docker container name conflicts
        COMPOSE_PROJECT_NAME = "springcloud_${BUILD_NUMBER}"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/charandevini/decentralizedlearningplatform.git'
            }
        }

        stage('Build Spring Boot App') {
            steps {
                echo '📦 Building all services:'
                echo '''
                    - naming-server
                    - api-gateway
                    - course-engine-service
                    - progress-tracker-service
                    - peer-review-hub-service
                '''
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Stop Old Containers') {
            steps {
                sh '''
                    echo "🛑 Stopping old containers..."
                    docker-compose down || true

                    echo "🧹 Removing all stopped containers..."
                    docker rm -f $(docker ps -aq) || true
                '''
            }
        }

        stage('Build & Deploy') {
            steps {
                echo '🚀 Starting containers for:'
                echo '''
                    - postgres
                    - naming-server
                    - zipkin-server
                    - api-gateway
                    - course-engine-service
                    - progress-tracker-service
                    - peer-review-hub-service
                '''
                sh '''
                    echo "⚙️ Building and deploying with docker-compose..."
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
        always {
            echo '📦 Cleaning up exited containers...'
            sh 'docker container prune -f || true'
        }
    }
}
