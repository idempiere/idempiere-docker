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
        stage('Publishing 8.2 to dockerhub') {
            steps {
                sh 'docker image rm -f $PROJECT_NAME:8.2'
                sh 'docker build -t $PROJECT_NAME:8.2 -t $PROJECT_NAME:phong ./8.2'
                sh 'docker push $PROJECT_NAME:8.2'
                sh 'docker push $PROJECT_NAME:phong'
            }
        }
    }
}
