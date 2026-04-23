pipeline {
    agent any

    options {
        timestamps()
        disableConcurrentBuilds()
        buildDiscarder(logRotator(numToKeepStr: '30'))
    }

    environment {
        REPO_URL    = 'https://github.com/idempiere/idempiere-docker.git'
        BRANCH_NAME = 'master'
        BUILD_DIR   = '13-daily'
        IMAGE_NAME  = 'idempiereofficial/idempiere'
        IMAGE_TAG   = '13-daily'
        DAILY_URL   = 'https://sourceforge.net/projects/idempiere/files/v13/daily-server/idempiereServer13Daily.gtk.linux.x86_64.zip/download'

        STATE_DIR   = '.jenkins-state'
        SHA_FILE    = '.last_daily_sha256'
        ZIP_NAME    = 'idempiere-server.zip'
        ZIP_TMP     = '/tmp/idempiereServer13Daily.zip'
    }

    triggers {
        cron('H H(1-4) * * *')
    }

    stages {

        stage('Prepare workspace') {
            steps {
                sh '''
                    set -eu
                    mkdir -p "${STATE_DIR}"
                '''
            }
        }

        stage('Download daily and calculate checksum') {
            steps {
                script {
                    sh '''
                        set -eu
                        rm -f "${ZIP_TMP}"

                        wget -O "${ZIP_TMP}" \
                             --tries=5 \
                             --retry-connrefused \
                             --waitretry=5 \
                             --read-timeout=60 \
                             --timeout=60 \
                             "${DAILY_URL}"

                        test -s "${ZIP_TMP}"
                        unzip -t "${ZIP_TMP}" >/dev/null
                        sha256sum "${ZIP_TMP}" | awk '{print $1}' > "${STATE_DIR}/${SHA_FILE}.new"
                    '''

                    env.NEW_SHA = sh(
                        script: "cat ${STATE_DIR}/${SHA_FILE}.new",
                        returnStdout: true
                    ).trim()

                    env.OLD_SHA = sh(
                        script: """
                            if [ -f "${STATE_DIR}/${SHA_FILE}" ]; then
                                cat "${STATE_DIR}/${SHA_FILE}"
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

        stage('Inject ZIP into build context') {
            when {
                expression { env.SHOULD_BUILD == 'true' }
            }
            steps {
                sh '''
                    set -eu
                    cp "${ZIP_TMP}" "repo/${BUILD_DIR}/${ZIP_NAME}"
                    test -f "repo/${BUILD_DIR}/${ZIP_NAME}"
                '''
            }
        }

        stage('Build image') {
            when {
                expression { env.SHOULD_BUILD == 'true' }
            }
            steps {
                dir("repo/${env.BUILD_DIR}") {
                    sh '''
                        set -eu
                        docker build --pull --no-cache \
                          --build-arg IDEMPIERE_ZIP_FILE="${ZIP_NAME}" \
                          -t ${IMAGE_NAME}:${IMAGE_TAG} \
                          .
                    '''
                }
            }
        }

        stage('Smoke test') {
            when {
                expression { env.SHOULD_BUILD == 'true' }
            }
            steps {
                sh '''
                    set -eu
                    docker run --rm --entrypoint bash ${IMAGE_NAME}:${IMAGE_TAG} -lc '
                        java -version &&
                        test -f /opt/idempiere/docker-entrypoint.sh &&
                        test -f /opt/idempiere/MD5SUMS
                    '
                '''
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
                        set -eu
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
                sh '''
                    set -eu
                    docker push ${IMAGE_NAME}:${IMAGE_TAG}
                '''
            }
        }

        stage('Persist checksum') {
            when {
                expression { env.SHOULD_BUILD == 'true' }
            }
            steps {
                sh '''
                    set -eu
                    mv "${STATE_DIR}/${SHA_FILE}.new" "${STATE_DIR}/${SHA_FILE}"
                '''
            }
        }

        stage('Skip info') {
            when {
                expression { env.SHOULD_BUILD != 'true' }
            }
            steps {
                echo 'Daily ZIP has not changed. Skipping build and push.'
            }
        }
    }

    post {
        always {
            sh '''
                rm -f "${ZIP_TMP}" || true
                rm -f "repo/${BUILD_DIR}/${ZIP_NAME}" || true
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