<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/4
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>邮箱注册</title>
</head>
<body>

   <form  action ="/a/u/registermeg" name="user" method="post">
 用户名：<input type="text" name="name"/><br>
    密码:<input type="text" name="password"/><br>
    邮箱:<input type="text" id="email" name="email"/><br>
    验证码:<input type="text" name="codea">
       <input type="button" value="获取验证码" onclick="sendCode()"/><br/>
    <input type="submit" value="注册"/><br/>
</form>

</body>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>


<script>
    function sendCode() {
        var xhr=new XMLHttpRequest();
        var email = $(" #email ").val();
        xhr.open('POST', '${pageContext.request.contextPath}/a/u/registermegcode', true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.send("email="+email);
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
