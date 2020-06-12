def call(params) {
    node {
        stage("拉一个代码") {
            git url: "${params.git_url}"
        }
        stage("执行一个命令"){
            execShell("${params.cmd}")
        }
        stage("打印现在的时间"){
            sh "date"
        }
        stage("input步骤"){
            inputMsg([id:"input1",msg:"我是一个input步骤"])
        }
    }
}