<%--
  Created by IntelliJ IDEA.
  User: li_xi
  Date: 2020/7/27
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String pash = request.getContextPath();
    String basepash = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + pash + "/";
%>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="http://unpkg.com/iview/dist/styles/iview.css">
    <script type="text/javascript" src="http://v1.vuejs.org/js/vue.min.js"></script>
    <script type="text/javascript" src="http://unpkg.com/iview@1.0.1/dist/iview.min.js"></script>
    <script type="text/javascript" src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<style>
    .card{
        position: relative;
        height: 400px;
        top: 180px;
        margin: 0 auto;
        /*left: 1200px;*/
        width: 400px;
        text-align:center;
    }
</style>
<body>
<div id="root">
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
                      
                    </div>
                    <form-Item prop="user">
                        <i-input sec:authentication="principal.username"  type="text"  placeholder="username"  name="username" v-model="name" @on-blur="a" @on-focus="empty">
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
<script>
    new Vue({
        el:"#root"
    })
</script>
</body>
</html>
