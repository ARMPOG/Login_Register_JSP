<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="css/index.css" type="text/css">
</head>
<body>

<h1><br>  <form align="center"> WELCOME <%=((User) session.getAttribute("currentUser")).getName()%> <br>
    <br>Enjoy music </h1>


<a href="/logout">Log out</a>

<br><iframe width="560" height="315" src="https://www.youtube.com/embed/NWOQVKHis0k" frameborder="0" allow="accelerometer;
 autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
<iframe width="560" height="315" src="https://www.youtube.com/embed/doVVuQ501_w" frameborder="0"
        allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe><br>
<br><iframe width="560" height="315" src="https://www.youtube.com/embed/lZOgjUfGTWA" frameborder="0"
            allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

</body>
</html>
