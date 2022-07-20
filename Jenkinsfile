pipeline {
  agent any

  stages {

    stage('Jobs Create') {
      steps {
        sh 'ansible-playbook -vvv jenkins-jobs.yml'
      }
    }

  }

}