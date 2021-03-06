def call(params) {

pipeline {
    agent any
    options {
        // 禁止同时运行多个流水线
        disableConcurrentBuilds()
    }
    environment {
        examples_var1 = sh(script: 'echo "当前的时间是: `date`"', returnStdout: true).trim()
    }
    stages{
        stage("声明式流水线: 拉一个代码") {
            steps {
                git url: "${params.git_url}"
            }
        }
        stage("声明式流水线: 执行一个命令"){
            steps {
                script {
                    sh "${params.cmd}"
                }
            }
        }
        stage("声明式流水线: 打印现在的时间"){
            steps {
                script {
                    inputMsg([id:"${params.input_id}",msg:"${params.input_msg}"])
                }

            }
        }   
    }
}


}