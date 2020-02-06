<%--
  Created by IntelliJ IDEA.
  User: ars
  Date: 05.02.20
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/index.css" type="text/css">
</head>
<body>

<div class="login-wrap">
    <div class="login-html">
        <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
        <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
        <div class="login-form">
            <div class="sign-in-htm">
                <form action="/login" method="post">
                    <div class="group">

                        <label for="emails" class="label">Email</label>
                        <input id="emails" type="text" name="email" class="input">
                    </div>
                    <div class="group">
                        <label for="pass" class="label">Password</label>
                        <input id="passs" type="password" name="password" class="input" data-type="password">
                    </div>
                    <div class="group">
                        <input id="check" type="checkbox" class="check" checked>
                        <label for="check"><span class="icon"></span> Keep me Signed in</label>
                    </div>
                    <div class="group">
                        <input type="submit" class="button" value="Sign In">
                    </div>

                    <c:if test="${login_errorMessage!=null}">
                    <div class="group">
                        <% String message = (String) request.getAttribute("login_errorMessage"); %>
                        <p style="color: red"><%=message%>
                        </p>
                    </div>
                    </c:if>
                    <div class="hr"></div>
                    <div class="foot-lnk">
                        <a href="#forgot">Forgot Password?</a>
                    </div>
            </div>
            </form>


            <div class="sign-up-htm">
                <form action="/register" method="post">
                <div class="group">
                    <label for="name" class="label">Name</label>
                    <input id="name" type="text" name="name" class="input">
                </div>
                <div class="group">
                    <label for="surn" class="label">Surname</label>
                    <input id="surn" type="text" name="surname" class="input" data-type="input">
                </div>
                <div class="group">
                    <label for="pass" class="label">Password</label>
                    <input id="pass" type="password" name="password" class="input" data-type="password">
                </div>
                <div class="group">
                    <label for="email" class="label">Email Address</label>
                    <input id="email" type="text" name="email" class="input">
                </div>
                <div class="group">
                    <input type="submit" class="button" value="Sign Up">
                </div>
                </form>
                <div class="hr"></div>
                <div class="foot-lnk">
                    <label for="tab-1">Already Member?</label>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
