pipeline {
  agent{
    node{
      label 'workstation'
    }
  }

  stages {

    stage('Jobs Create') {
      steps {
        sh 'ansible-playbook jenkins-jobs.yml'
      }
    }

  }

}