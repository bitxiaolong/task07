<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/2
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="/a/u/register" name="user" method="post"/>
用户名：<input type="text" name="name"/><br>
密码  :<input type="text" name="password"/><br>
<%--       <form action="/a/u/registerPhone" name="get" method="get">--%>
手机号：    <input type="text" id="phone" name="phone"/><br>
验证码：    <input type="text" name="code"/>
           <input type="button" value="获取验证码" onclick="sendCode()"/><br/>
<%--       </form>--%>
    <input type="submit" value="注册"/>
</form>

<form action="/a/u/upload" name="user" method="post" enctype="multipart/form-data"/>
选择图片：<input type="file" name="file"/><br>
<%--       <form action="/a/u/registerPhone" name="get" method="get">--%>
<input type="submit" value="上传"/>
</form>


</body>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>


<script>
    function sendCode() {
        var xhr=new XMLHttpRequest();
        var phone = $(" #phone ").val();
        xhr.open('POST', '${pageContext.request.contextPath}/a/u/registerphonecode', true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.send("phone="+phone);
        // var resultData=xhr.responseText;
        console.log(xhr);
        var resultData=JSON.parse(xhr.response);
        console.log(resultData);
        if(resultData.code==0){
            alert("success send code");
        }else {
            alert("cannot send code in 5 min for 3 times above");
        }
    }
</script>

</html>
