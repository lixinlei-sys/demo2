
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
    
</style>
<script>
    var lj="<%=request.getContextPath()%>";
</script>
<body>
<div id="root">
    <div class="layout">
        <Menu mode="horizontal" theme="dark" active-key="1">
            <div class="layout-logo"></div>
            <div class="layout-nav">
                <Menu-item key="1">
                    <Icon type="ios-navigate"></Icon>
                    导航一
                </Menu-item>
                <Menu-item key="2">
                    <Icon type="ios-keypad"></Icon>
                    导航二
                </Menu-item>
                <Menu-item key="3">
                    <Icon type="ios-analytics"></Icon>
                    导航三
                </Menu-item>
                <Menu-item key="4">
                    <Icon type="ios-paper"></Icon>
                    导航四
                </Menu-item>
            </div>
        </Menu>
        <Menu mode="horizontal" active-key="1">
            <div class="layout-assistant">
                <Menu-item key="1">二级导航</Menu-item>
                <Menu-item key="2">二级导航</Menu-item>
                <Menu-item key="3">二级导航</Menu-item>
            </div>
        </Menu>
        <div class="layout-content">
            <Row>
                <i-col span="5">
                    <Menu active-key="1-2" width="auto" :open-keys="['1']">
                        <Submenu key="1">
                            <template slot="title">
                                <Icon type="ios-navigate"></Icon>
                                导航一
                            </template>
                            <Menu-item key="1-1">选项 1</Menu-item>
                            <Menu-item key="1-2">选项 2</Menu-item>
                            <Menu-item key="1-3">选项 3</Menu-item>
                        </Submenu>
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
                </i-col>
                <i-col span="19">
                    <div class="layout-content-main">内容区域</div>
                </i-col>
            </Row>
        </div>
    </div>
</div>
    
</body>
<script>
    new Vue({
        el:"#root",
        data:{
           

        },
        methods:{
           
        },

        mounted(){
          
        },
        created(){
            that=this;              /*局外变量 that等于this*/
        },

    })
</script>
</html>
