const base = {
    get() {
        return {
            url : "http://localhost:8080/xnr/",
            name: "xnr",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xnr/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "新农人交流论坛"
        } 
    }
}
export default base
