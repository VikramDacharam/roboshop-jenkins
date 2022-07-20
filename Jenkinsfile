pipeline {
  agent any

  options {
    ansiColor('xterm')
  }

  stages {

    stage('Jobs Create') {
      steps {
        sh 'ansible-playbook -vv jenkins-jobs.yml'
      }
    }

  }
}