def call() {
    pipeline {
        agent any

        parameters {
            string(name: 'ENV', defaultValue: '', description: 'Which Environment?')
        }

        environment {
            SSH = credentials('SSH')
        }

        stages {

            stage('Terraform INIT') {
                steps {
                    sh '''
                    terraform init -backend-config=env-${ENV}/backend.tfvars
                    '''
                }
            }
        }
    }
}