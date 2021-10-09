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
        stage('Publishing 8.2-daily to dockerhub') {
            steps {
                sh 'docker image rm -f $PROJECT_NAME:8.2-daily'
                sh 'docker build --no-cache -t $PROJECT_NAME:latest -t $PROJECT_NAME:8.2-daily ./8.2-daily'
                sh 'docker push $PROJECT_NAME:latest'
                sh 'docker push $PROJECT_NAME:8.2-daily'
            }
        }
        stage('Publishing 8.2-master to dockerhub') {
            steps {
                sh 'docker image rm -f $PROJECT_NAME:8.2-master'
                sh 'docker build --no-cache -t $PROJECT_NAME:latest -t $PROJECT_NAME:8.2-master ./8.2-master'
                sh 'docker push $PROJECT_NAME:8.2-master'
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
        stage('Publishing 8.2-demo to dockerhub') {
            steps {
                sh 'docker image rm -f $PROJECT_NAME:8.2-demo'
                sh 'docker build --no-cache -t $PROJECT_NAME:8.2-demo -t $PROJECT_NAME:phong-demo ./8.2-demo'
                sh 'docker push $PROJECT_NAME:8.2-demo'
            }
        }
        //stage('Publishing source-master to dockerhub') {
        //    steps {
        //        sh 'docker image rm -f $PROJECT_NAME:source-master'
        //        sh 'docker build --no-cache -t $PROJECT_NAME:source-master ./source-master'
        //        sh 'docker push $PROJECT_NAME:source-master'
        //    }
        //}
        stage('Publishing source-release-8.2 to dockerhub') {
            steps {
                sh 'docker image rm -f $PROJECT_NAME:source-release-8.2'
                sh 'docker build --no-cache -t $PROJECT_NAME:source-release-8.2 ./source-release-8.2'
                sh 'docker push $PROJECT_NAME:source-release-8.2'
            }
        }
    }
}
