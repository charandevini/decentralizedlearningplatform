pipeline {
    agent any

    environment {
        COMPOSE_PROJECT_NAME = "springcloud_${BUILD_NUMBER}"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/charandevini/decentralizedlearningplatform.git'
            }
        }

        stage('Build Spring Boot Apps') {
            steps {
                echo '📦 Building Spring Boot services individually...'
                dir('naming-server') {
                    sh 'mvn clean package -DskipTests'
                }
                dir('api-gateway') {
                    sh 'mvn clean package -DskipTests'
                }
                dir('course-engine-service') {
                    sh 'mvn clean package -DskipTests'
                }
                dir('progress-tracker-service') {
                    sh 'mvn clean package -DskipTests'
                }
                dir('peer-review-hub-service') {
                    sh 'mvn clean package -DskipTests'
                }
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
                echo '🚀 Building and starting containers with Docker Compose...'
                sh 'docker-compose up -d --build'
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
