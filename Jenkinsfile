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
               echo '📦 Auto-building all Maven projects...'
               sh '''
                   for dir in $(find . -name "pom.xml" -exec dirname {} \\;); do
                       echo "🔧 Building $dir"
                       (cd "$dir" && mvn clean package -DskipTests)
                   done
               '''
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
