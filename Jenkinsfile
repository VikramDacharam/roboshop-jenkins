pipeline {
  agent any

  options {
    ansiColor('xterm')
  }

  stages {

    stage('Jobs Create') {
      steps {
        sh 'ansible-playbook -vvv jenkins-jobs.yml'
      }
    }

  }