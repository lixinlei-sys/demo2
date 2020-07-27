<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String pash = request.getContextPath();
    String basepash = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + pash + "/";
%>
<html>
<head>
    <title>Molinks数据监测系统</title>
    
</head>
<link rel="stylesheet" href="http://unpkg.com/iview/dist/styles/iview.css">
<script type="text/javascript" src="http://v1.vuejs.org/js/vue.min.js"></script>
<script type="text/javascript" src="http://unpkg.com/iview@1.0.1/dist/iview.min.js"></script>
<script type="text/javascript" src="https://unpkg.com/axios/dist/axios.min.js"></script>
<%--<script type="text/javascript" src="/static/js/login.js"></script>
<link rel="stylesheet" type="text/css" href="/webjars/iview/3.4.0/dist/styles/iview.css">
<script type="text/javascript" src="/webjars/iview/3.4.0/dist/iview.js"></script>
<script type="text/javascript" src="/webjars/vue/2.6.10/dist/vue.js"></script>
<script type="text/javascript" src="/webjars/axios/0.19.2/dist/axios.js"></script>
<script type="text/javascript" src="/webjars/moment/2.24.0/moment.js"></script>--%>
<style>
    .theme{
        height: 100%;
        background-color: red;
        background: url("/static/img/zc-bgimg.jpg") no-repeat;       /*背景图片争取也要改*/
        background-size:100%;
        background-attachment: fixed;
        /*overflow: hidden;*/
    }                     /*错误不用管 ES语法不一样*/
    .txk{
        width: 80px;
        height: 80px;
        margin-left: 40px;
        border-radius: 50px;
        margin-bottom: 10px;
    }            /*头像框的样式*/
    .card{
        position: relative;
        height: 400px;
        top: 180px;
        margin: 0 auto;
        /*left: 1200px;*/
        width: 400px;
        text-align:center;
    }           /*card定位样式*/

    .login-icon{
        width: 200px;
        height: 120px;
        margin: 0px auto;
        /*margin-bottom: 20px;
        margin: 5px 70px;*/
        /*background-image: url("/static/img/login/app.jpg");
        background-position: center;
        background-repeat: no-repeat;
        background-size:100%;
        background-attachment: fixed;*/
    }             /*默认头像的样式*/
    .img{
        width: 100%;
        height: 100%;
    }
</style>
<script>
    var lj="<%=request.getContextPath()%>";

</script>
<body>
    <div id="tian">
        <div class="theme">
            <card style="background-color: rgba(213,213,213,0.16)" class="card" >
                <div class="temp">
                <i-form style="padding:20px 20px"  action="/login" method="post">
                    <%--<c:if test="${not empty loginErr}">
                        <alert type="error" show-icon>${loginErr}</alert>
                    </c:if>
                        <div class="tx">
                            <img :src="txx" alt="" class="txk">       &lt;%&ndash;头像要改为数据库的默认头像&ndash;%&gt;

                            <p style="font-size: 18px;margin-left: 5px;color: whiteSmoke;">物业管理系统—登录</p>
                        </div>--%>
                    <div class="login-icon">
                        <!--着里吗-->
                        <img class="img" src="/static/img/login/app.jpg" >
                    </div>
                     <form-Item prop="user">
                         <i-input sec:authentication="principal.username"  type="text"  placeholder="username"  name="name" v-model="name" @on-blur="a" @on-focus="empty">
                         <icon type="md-person" slot="prepend" size="20"></icon>
                         </i-input>
                     </form-Item>
                     <form-Item prop="password">
                         <i-Input  sec:authentication="principal.password"  type="password" placeholder="password" name="password"  >
                         <Icon type="md-lock" slot="prepend"  size="20"></Icon>
                         </i-Input>
                     </form-Item>
                 <i-button html-type="submit" type="success" long style="margin-left: 0px">登 录</i-button>
                </i-form>
                </div>
            </card>
        </div>
    </div>
</body>
<script>
    new Vue({
        el:"#tian",
        data:{
            txx:"static/img/nulltx.png",             /*默认头像为空*/
            backstage:{},    /*后台用户信息对象*/
            name:"",

        },
        methods:{
            loginSubmit(){
                if (this.name!=null){
                    if(this.password.length>1){
                        axios.post(`${lj}/login`,this.name,this.password)
                            .then(({data})=>{

                            })
                    }else{
                        console.log(this.password.length)
                        this.$Message.warning({
                            content:"密码不能小于6位",
                            top: 50,
                            duration: 3
                        });
                    }
                }else{
                    this.$Message.warning({
                        content:"用户名不能为空",
                        top: 50,
                        duration: 3
                    });
                }
            },       /*表单验证和数据提交*/
            a(){
                axios.get(`${lj}/findTx?name=${this.name}`).then(({data})=>{
                    that.txx=data.msg;
                });
            },                  /*当管理员输入账号时，失去焦点 这里执行查询用户头像操作*/
            empty(){

            }       /*当用户重新编辑,接受的loginErr就会清空*/
        },

        mounted(){
            this.a()/*页面默认加载事件*/
        },
        created(){
            that=this;              /*局外变量 that等于this*/
        },


    })
</script>
<script>
</script>
</html>
