pipeline {
    agent any

    options {
        timestamps()
        disableConcurrentBuilds()
        buildDiscarder(logRotator(numToKeepStr: '30'))
    }

    environment {
        REPO_URL        = 'https://github.com/idempiere/idempiere-docker.git'
        BRANCH_NAME     = 'master'
        BUILD_DIR       = '13-daily'
        IMAGE_NAME      = 'idempiereofficial/idempiere'
        IMAGE_TAG       = '13-daily'
        DAILY_URL       = 'https://sourceforge.net/projects/idempiere/files/v13/daily-server/idempiereServer13Daily.gtk.linux.x86_64.zip/download'
        SHA_FILE        = '.last_daily_sha256'
        ZIP_FILE        = '/tmp/idempiereServer13Daily.zip'
    }

    triggers {
        cron('H H(1-4) * * *')
    }

    stages {

        stage('Prepare workspace') {
            steps {
                sh '''
                    set -e
                    mkdir -p .jenkins-state
                '''
            }
        }

        stage('Download daily and calculate checksum') {
            steps {
                script {
                    sh """
                        set -eu
                        curl -L --fail --silent --show-error "${DAILY_URL}" -o "${ZIP_FILE}"
                        sha256sum "${ZIP_FILE}" | awk '{print \$1}' > ".jenkins-state/${SHA_FILE}.new"
                    """

                    env.NEW_SHA = sh(
                        script: "cat .jenkins-state/${SHA_FILE}.new",
                        returnStdout: true
                    ).trim()

                    env.OLD_SHA = sh(
                        script: """
                            if [ -f ".jenkins-state/${SHA_FILE}" ]; then
                                cat ".jenkins-state/${SHA_FILE}"
                            fi
                        """,
                        returnStdout: true
                    ).trim()

                    if (env.OLD_SHA == env.NEW_SHA && env.OLD_SHA != '') {
                        env.SHOULD_BUILD = 'false'
                        currentBuild.description = "No change in daily ZIP (${env.NEW_SHA.take(12)})"
                    } else {
                        env.SHOULD_BUILD = 'true'
                        currentBuild.description = "New daily ZIP detected (${env.NEW_SHA.take(12)})"
                    }

                    echo "OLD_SHA=${env.OLD_SHA}"
                    echo "NEW_SHA=${env.NEW_SHA}"
                    echo "SHOULD_BUILD=${env.SHOULD_BUILD}"
                }
            }
        }

        stage('Checkout repo') {
            when {
                expression { env.SHOULD_BUILD == 'true' }
            }
            steps {
                dir('repo') {
                    deleteDir()
                    git branch: "${env.BRANCH_NAME}", url: "${env.REPO_URL}"
                }
            }
        }

        stage('Build image') {
            when {
                expression { env.SHOULD_BUILD == 'true' }
            }
            steps {
                dir("repo/${env.BUILD_DIR}") {
                    sh """
                        set -eu
                        docker build --pull --no-cache \\
                          --build-arg IDEMPIERE_BUILD="${DAILY_URL}" \\
                          -t ${IMAGE_NAME}:${IMAGE_TAG} \\
                          .
                    """
                }
            }
        }

        stage('Smoke test') {
            when {
                expression { env.SHOULD_BUILD == 'true' }
            }
            steps {
                sh """
                    set -eu
                    docker run --rm --entrypoint bash ${IMAGE_NAME}:${IMAGE_TAG} -lc '
                        java -version &&
                        test -f /opt/idempiere/docker-entrypoint.sh
                    '
                """
            }
        }

        stage('Login Docker Hub') {
            when {
                expression { env.SHOULD_BUILD == 'true' }
            }
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh '''
                        set -e
                        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                    '''
                }
            }
        }

        stage('Push image') {
            when {
                expression { env.SHOULD_BUILD == 'true' }
            }
            steps {
                sh """
                    set -eu
                    docker push ${IMAGE_NAME}:${IMAGE_TAG}
                """
            }
        }

        stage('Persist checksum') {
            when {
                expression { env.SHOULD_BUILD == 'true' }
            }
            steps {
                sh """
                    set -eu
                    mv ".jenkins-state/${SHA_FILE}.new" ".jenkins-state/${SHA_FILE}"
                """
            }
        }

        stage('Skip info') {
            when {
                expression { env.SHOULD_BUILD != 'true' }
            }
            steps {
                echo "Daily ZIP has not changed. Skipping build and push."
            }
        }
    }

    post {
        always {
            sh '''
                rm -f /tmp/idempiereServer13Daily.zip || true
                docker logout || true
                docker image prune -f || true
            '''
        }
        success {
            echo "Pipeline finished successfully"
        }
        failure {
            echo "Pipeline failed"
        }
    }
}