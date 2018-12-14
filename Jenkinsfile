import static com.zuora.owl.jenkins.BuildHelper.*

pipeline {
    agent {
        label 'ec2-fleet'
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '30'))
        disableConcurrentBuilds()
        skipStagesAfterUnstable()
        timeout(time: 120, unit: 'MINUTES')

        timestamps()
    }

    tools {
        jdk 'jdk11'
    }

    stages {
        stage('Clean') {
            steps {
                script {
                    maven().cleanOwlProject()
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    maven().buildOwlProject()
                }
            }
        }

        stage('Branch-Maven-Deploy') {
            when {
                branch 'zuora-\\d+'
                expression { isSucceeding() }
            }
            steps {
                script {
                    maven().deployOwlProject()
                }
            }
        }

    }

    post {
        fixed {
            script {
                notification().notifySlack("#owl")
            }
        }

        unstable {
            script {
                notification().notifySlack("#owl")
            }
        }

        failure {
            script {
                notification().notifySlack("#owl")
            }
        }
    }
}
