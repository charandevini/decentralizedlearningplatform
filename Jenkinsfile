pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/charandevini/decentralizedlearningplatform.git'
            }
        }

        stage('Stop Running Containers') {
            steps {
                sh '''
                    docker-compose down || true
                    docker rm -f $(docker ps -aq) || true
                '''
            }
        }

        stage('Build & Start Services') {
            steps {
                sh 'docker-compose up -d --build'
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
