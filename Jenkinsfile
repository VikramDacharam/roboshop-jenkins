pipeline{
  agent any

  stages{
    stage('jobs create'){
      steps{
        sh 'ansible-playbook jenkins-jobs.yml'
      }
    }
  }
}