<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Login.css"/>
<title>登录页面</title>
</head>
<body bgcolor="#FFFFFF">



    <div id="login">
        <h1>Login</h1>
        <form action="LoginAction.action" method="post" onsubmit="return panduan();">
            <input type="text" required="required" placeholder="用户名" name="UName" id="UName"></input>

            <input type="password" required="required" placeholder="密码" name="PWD" id="PWD"></input>
            <button class="but" type="submit">登录</button><a href="register.jsp">注册</a>
        </form>
    </div>



	<script type="text/javascript">
		function panduan() {
			var name = document.getElementById("UName").value
			//用户名
			var mima1 = document.getElementById("PWD").value
			//取出第一个文本框里输如的值密码一
			/* var mima2 = document.getElementById("PWD2").value
			取出第二个文本框里输如的值密码二 */
			if (name == "") {
				alert("用户名为空")
				document.getElementById("UName").focus()
				return false;
			} else {
				if (mima1 == "") {
					alert("密码为空")
					document.getElementById("PWD").focus()
					return false;
				} else {

						alert("成功！")
						//输出对话框提示
						return true;
					}
				}
			}

	</script>
</body>
</html>
