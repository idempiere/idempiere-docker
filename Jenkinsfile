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
        REGISTRY_PASS = credentials('idempiereofficial-dockerhub')
    }
    stages {
        stage('Publish 8.2 to dockerhub') {
            steps {
                sh 'docker images'
                sh 'docker login -u $REGISTRY_USER -p $REGISTRY_PASS'
                sh 'docker build -t $PROJECT_NAME:8.2 -t $PROJECT_NAME:phong ./8.2'
                sh 'docker push $PROJECT_NAME --all-tags'
            }
        }
    }
}
