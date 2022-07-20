pipeline {
  agent any

  stages {

    stage('Jobs Create') {
      steps {
        sh 'ansible-playbook -vv jenkins-jobs.yml'
      }
    }

  }
}