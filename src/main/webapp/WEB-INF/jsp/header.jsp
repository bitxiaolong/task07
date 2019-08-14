<%@ page import="com.encryption.DESUtil" %>
<%@ page import="com.encryption.JWTUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
<%--    <%=session.getAttribute("user")%>--%>
    <!DOCTYPE html>
     <html>
     <head>
     <meta charset="uft-8" name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
     <title>task8</title>
<%--     <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>--%>
<%--     <link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.css" rel="stylesheet">--%>
<%--     <script src="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/js/bootstrap.js"></script>--%>
<%--     <link type="text/css" rel="stylesheet" href="../reset.css"/>--%>
<%--     <link type="text/css" rel="stylesheet" href="../style.css"/>--%>

     <link href="${pageContext.request.contextPath}/static/css-5/bootstrap.min.css" rel="stylesheet" type="text/css">
     <link href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css">
     <link href="${pageContext.request.contextPath}/static/css-5/Untitled-3.css" rel="stylesheet" type="text/css">
     <link href="${pageContext.request.contextPath}/static/css-5/Untitled-1base.css" rel="stylesheet" type="text/css">
     </head>
      <body>
      <%boolean result = false;
        String value = null;
      %>
      <%
      Cookie[] c = request.getCookies();
      for (int i = 0;i<c.length;i++) {
          if (c[i].getName().equals("token")){
              DESUtil desUtil = new DESUtil();
              value = desUtil.decrypt(c[i].getValue());
//              System.out.println("成功查找到名字的cookie");
//             value = desUtil.decrypt(c[i].getValue());
//              System.out.println("这是我们需要的信息:"+value1);
              result=true;
      }else
          {
          result=false;
          }
      }
      %>
      <div class="container  hidden-xs">
      <div class="row header-top">
      <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">客服电话:010-594-78634</p>
                    <c:choose>
                        <c:when test="<%=result%>">
                            <i style="color:red;font-size:x-small"><%=value%>欢迎您</i>
                            <a href="/loginout" style="color:blue">退出登录</a>
                        </c:when>
                        <c:otherwise>
                            <a href="/a/u/register" style="color:blue">手机注册</a>
                            <a href="/a/u/mail" style="color: blue">邮箱注册</a>
                            <a href="${pageContext.request.contextPath}/a/u/login" style="color:blue">登录</a>
                        </c:otherwise>
                    </c:choose>
      <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
      </div>
        <div>
      <a href="#" target="_blank"> <img alt=""  src="${pageContext.request.contextPath}/static/images/54537.png"></a>
      <a href="#" target="_blank"><img alt=""  src="${pageContext.request.contextPath}/static/images/45678678.png"></a>
      <a href="#" target="_blank"> <img alt=""  src="${pageContext.request.contextPath}/static/images/54375483543.png"></a>

        </div>
      </div>
      </div>
      </div>

      <nav class="navbar navbar-default">
      <div class="container">
      <div class="navbar-header">
      <a href="#" class="navbar-brand">
      <img src="${pageContext.request.contextPath}/static/images/logo.png" alt="Brand" class="img-responsive">
      </a>
      <button data-target="#open-nav" data-toggle="collapse" class="navbar-toggle btn-primary collapsed" aria-expanded="false">
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      </button>
      </div>
      <div id="open-nav" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
      <ul class="nav navbar-nav navbar-right text-center list-inline">
      <li><a href="">首页</a></li>
      <li><a href="/u/job">职业</a></li>
      <li><a href="">推荐</a></li>
      <li><a href="">关于</a></li>
      </ul>
      </div>

      </div>
      </nav>
      </body>
