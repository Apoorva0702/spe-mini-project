pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    environment {
        DOCKER_IMAGE = "apoorvakharya/scientific-calculator"
    }

    stages {

        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(
                        credentialsId: 'dockerhub-credentials',
                        usernameVariable: 'DOCKER_USER',
                        passwordVariable: 'DOCKER_PASS'
                )]) {

                    sh 'docker login -u $DOCKER_USER -p $DOCKER_PASS'
                    sh 'docker push $DOCKER_IMAGE'
                }
            }
        }

        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook ansible/deploy.yml -i ansible/hosts'
            }
        }

    }

    post {
        success {
            mail to: 'apoorvakharya07@gmail.com',
                    subject: "Jenkins Build Success: ${env.JOB_NAME}",
                    body: "The pipeline completed successfully."
        }

        failure {
            mail to: 'apoorvakharya07@gmail.com',
                    subject: "Jenkins Build Failed: ${env.JOB_NAME}",
                    body: "The pipeline failed. Check Jenkins logs."
        }
    }
}