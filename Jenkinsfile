pipeline{
  agent {
    node {
      label 'workstation'
    }

  }

  stages{
    stage('jobs create'){
      steps{
        sh 'ansible-playbook jenkins-jobs.yml'
      }
    }
  }
}