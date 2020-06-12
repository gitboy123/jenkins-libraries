
def call(params){

    // 定义jenkinsfile的路径
    def jenkinsfile_dir = "/data/jenkins-jenkinsfile/"

    node {
        // echo "${jenkinsfile_dir}"
        // echo "${params.env.JOB_NAME}"
        // 加载Jenkinsfile的groovy文件
        def jenkinsfile = load("${jenkinsfile_dir}/${params.env.JOB_NAME}.groovy")

        // 调用groovy中的call函数,将params也就是job运行时的所有公开的函数和变量传进去                   
        jenkinsfile.call(params)

        // "${name}"(params)
        //evaluate('aaa(params)')
        
    }
}