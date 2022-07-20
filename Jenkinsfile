pipeline{
  agent {
    node{
      label 'ansible'
    }
  }

  stages{
    stage('jobs create'){
      steps{
        sh 'ansible-playbook -vv jenkins-jobs.yml'
      }
    }
  }
}