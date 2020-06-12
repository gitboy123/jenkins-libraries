def call(params){
    try {
        input(
            id: "${params.id}", message: "${params.msg}"
        )
    } catch(err) { 
        // 获取执行Input的用户
        env.user = err.getCauses()[0].getUser().toString()
        userInput = false
        env.QATEST_TEST = false
        echo "Aborted by: [${user}]"
        // 抛出异常确保流程终止
        throw err
    } 

}