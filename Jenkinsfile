pipeline {
    agent {
        docker { 
            image 'docker:20' 
        }
    }
    triggers {
        cron('@daily')
    }
    environment {
        PROJECT_NAME = 'idempiereofficial/idempiere'
        DOCKERHUB = credentials('idempiereofficial-dockerhub')
    }
    stages {
        stage('Login into dockerhub') {
            steps {
                sh 'docker login -u $DOCKERHUB_USR -p $DOCKERHUB_PSW'
            }
        }
        stage('Publishing 9-release to dockerhub') {
            steps {
                sh 'docker image rm -f $PROJECT_NAME:9'
                sh 'docker build --no-cache -t $PROJECT_NAME:release -t $PROJECT_NAME:9 ./9'
                sh 'docker push $PROJECT_NAME:release'
                sh 'docker push $PROJECT_NAME:9'
            }
        }
        
        stage('Publishing 9-daily to dockerhub') {
            steps {
                sh 'docker image rm -f $PROJECT_NAME:9-daily'
                sh 'docker build --no-cache -t $PROJECT_NAME:daily -t $PROJECT_NAME:9-daily ./9-daily'
                sh 'docker push $PROJECT_NAME:9-daily'
                sh 'docker push $PROJECT_NAME:9-daily'
            }
        }
        
        stage('Publishing 9-master to dockerhub') {
            steps {
                sh 'docker image rm -f $PROJECT_NAME:9-master'
                sh 'docker build --no-cache -t $PROJECT_NAME:latest -t $PROJECT_NAME:9-master ./9-master'
                sh 'docker push $PROJECT_NAME:9-master'
            }
        }
        stage('Publishing 8.2 to dockerhub') {
            steps {
                sh 'docker image rm -f $PROJECT_NAME:8.2'
                sh 'docker build --no-cache -t $PROJECT_NAME:8.2 -t $PROJECT_NAME:phong ./8.2'
                sh 'docker push $PROJECT_NAME:8.2'
                sh 'docker push $PROJECT_NAME:phong'
            }
        }
         stage('Publishing source-release-9 to dockerhub') {
            steps {
                sh 'docker image rm -f $PROJECT_NAME:source-release-9'
                sh 'docker build --no-cache -t $PROJECT_NAME:source-release-9 ./source-release-9'
                sh 'docker push $PROJECT_NAME:source-release-9'
            }
         }
        stage('Publishing source-release-8.2 to dockerhub') {
            steps {
                sh 'docker image rm -f $PROJECT_NAME:source-release-8.2'
                sh 'docker build --no-cache -t $PROJECT_NAME:source-release-8.2 ./source-release-8.2'
                sh 'docker push $PROJECT_NAME:source-release-8.2'
            }
        }
    }
}
