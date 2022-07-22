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

        stages {
            stage("create instance"){
                steps{
                    sh 'bash create-ec2-with-env.sh ${COMPONENT} ${ENV}'
                }
            }
            stage(' Run Ansible '){
                steps {
                    sh 'ansible-playbook -i inv roboshop.yml -e HOST=${COMPONENT} -e ROLE_NAME=${COMPONENT} -e ENV=${ENV} -e ansible_user=${SSH_USR} -e ansible_password=${SSH_PSW}'
                }
            }

        }

    }
}