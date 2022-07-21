pipeline {
  agent{
    node{
      label 'ansible'
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