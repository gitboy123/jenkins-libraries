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
        stage("dev: 执行一个命令"){
            steps {
                script {
                    sh "ls -al"
                }
            }
        }
        stage("dev: 打印现在的时间"){
            steps {
                echo "${examples_var1}"
            }
        }
        stage("dev: 打印JOB_NAME"){
            steps {
                echo "${JOB_NAME}"
            }
        }      
    }
}


}


// 记得要return哟,因为我们是调用这个文件
return this