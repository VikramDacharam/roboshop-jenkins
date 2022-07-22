def call (){
    pipeline {
        agent any

        parameters {
            string(name: 'ENV', defaultValue: '', description: 'which environment?')
            string(name: 'COMPONENT', defaultValue: '', description: 'which Component?')
        }
        environment {
            SSH = credentials('SSH')
        }
        stages{
            stage('Checkout code - DEV'){
                when {
                    expression{
                        ENV == "dev"
                    }
                }
                steps{
                    dir('ANSIBLE'){
                        git branch: 'dev', url: 'https://github.com/VikramDacharam/roboshop-jenkins.git'
                    }

                }
            }
            stage('Checkout code - PROD'){
                when {
                    expression{
                        ENV == "prod"
                    }
                }
                steps{
                    dir('ANSIBLE'){
                        git branch: 'main', url: 'https://github.com/VikramDacharam/roboshop-jenkins.git'
                    }
                }
            }
        }
        stages{
            stage("create instance"){
                steps{
                    dir('ANSIBLE') {
                        sh 'bash create-ec2-with-env.sh ${COMPONENT} ${ENV}'
                    }
                }
            }
            stage(' Run Ansible '){
                steps {
                    dir('ANSIBLE') {
                        sh 'ansible-playbook -i inv roboshop.yml -e HOST=${COMPONENT} -e ROLE_NAME=${COMPONENT} -e ENV=${ENV} -e ansible_user=${SSH_USR} -e ansible_password=${SSH_PSW}'
                    }               }
            }
        }

    }
}