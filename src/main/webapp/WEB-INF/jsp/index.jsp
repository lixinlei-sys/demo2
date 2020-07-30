<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String pash = request.getContextPath();
    String basepash = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + pash + "/";
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="http://unpkg.com/iview/dist/styles/iview.css">
    <script type="text/javascript" src="http://v1.vuejs.org/js/vue.min.js"></script>
    <script type="text/javascript" src="http://unpkg.com/iview@1.0.1/dist/iview.min.js"></script>
    <%--<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>--%>
</head>
<style>
    .layout{
        border: 1px solid #d7dde4;
        background: #f5f7f9;
        position: relative;
        height: 100%;
    }
    .layout-breadcrumb{
        padding: 10px 15px 0;
    }
    .layout-content{
        height: 680px;
        min-height: 200px;
        margin: 15px;
        /*overflow: hidden;*/
        background: #fff;
        border-radius: 4px;
    }
    .layout-content-main{
        padding: 10px;
        width: 100%;
    }
    .layout-copy{
        text-align: center;
        padding: 10px 0 20px;
        color: #9ea7b4;
    }
    .layout-menu-left{
        background: #464c5b;
        width: 18%;
    }
    .layout-header{
        height: 60px;
        background: #fff;
        box-shadow: 0 1px 1px rgba(0,0,0,.1);
    }
    .layout-logo-left{
        width: 90%;
        height: 30px;
        background: #5b6270;
        border-radius: 3px;
        margin: 15px auto;
    }
    .ivu-row-flex{
        height: 100%;
    }
    #root{
        height:100%;
        width: 100%;
        /*overflow: hidden;*/
    }
    .layout-content-main{
        height: auto;
        width: 100%;
        padding-left: 0px;
    }
    .ivu-col ivu-col-span-19{
        width: 100%;
    }
</style>
<script>
    var lj="<%=request.getContextPath()%>";
</script>
<body>
<div id="root">
    <div class="layout">
        <Row type="flex">
            <i-col span="5" class="layout-menu-left">
                <Menu active-key="1-2" theme="dark" width="auto" :open-keys="['1']">
                    <div class="layout-logo-left"></div>
                    <sec:authorize access="isAuthenticated()">
                        <Submenu key="1">
                            <template slot="title">
                                <Icon type="ios-navigate"></Icon>
                                导航一
                            </template>
                            <sec:authorize access="hasRole('USER')">
                                <Menu-item key="1-1">
                                    <a href="aaa.jsp" target="theme" style="color: aquamarine">用户</a>
                                </Menu-item>
                            </sec:authorize>
                            <sec:authorize access="hasRole('USER')">
                                <Menu-item key="1-2">设备</Menu-item>
                            </sec:authorize>
                            <Menu-item key="1-3">选项 3</Menu-item>
                        </Submenu>
                    </sec:authorize>
                    <Submenu key="2">
                        <template slot="title">
                            <Icon type="ios-keypad"></Icon>
                            导航二
                        </template>
                        <Menu-item key="2-1">选项 1</Menu-item>
                        <Menu-item key="2-2">选项 2</Menu-item>
                    </Submenu>
                    <Submenu key="3">
                        <template slot="title">
                            <Icon type="ios-analytics"></Icon>
                            导航三
                        </template>
                        <Menu-item key="3-1">选项 1</Menu-item>
                        <Menu-item key="3-2">选项 2</Menu-item>
                    </Submenu>
                </Menu>
                <div class="ivu-menu-submenu">
                <Icon type="person-stalker"></Icon>
                <%--<span style="color: aqua;font-size:large;position:absolute;bottom: 0px">用户:<sec:authentication property="principal.username"/></span>--%>
                </div>
            </i-col>
            <i-col span="19">
                <%--<div class="layout-header"></div>--%>
                <div class="layout-content" style="width: 100%">
                    <div class="layout-content-main">
                        <Layout :style="width: 1200px">
                            <Layout :style="{padding: '0 5px 0px'}">
                                <i-Content :style="{minHeight: '400px', background: '#fff'}">             <%--页面默认加载--%>
                                    <iframe name="theme" width="100%" height="100%" frameborder="0" src="https://www.baidu.com"></iframe>
                                </i-Content>
                            </Layout>
                        </Layout>
                    </div>
                </div>  
            </i-col>
        </Row>
    </div>
</div>
    
</body>
<script>
    var _that=null;
    new Vue({
        el:"#root",
        data:{
           

        },
        methods:{
           
        },

        mounted(){
          
        },
        created(){
            _that=this;              /*局外变量 that等于this*/
        },

    })
</script>
</html>
