<%--
  Created by IntelliJ IDEA.
  User: gerber
  Date: 17.10.2018
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vote Success</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/login-pagecss.css"/>
    <link href="https://fonts.googleapis.com/css?family=Cinzel" rel="stylesheet">
</head>

<body>
<div class="box">
    <img src="${pageContext.request.contextPath}/resources/images/success.jpg" class="avatar">
    <h1>Success!</h1>
    <h3>
        Thank you for the vote!</h3>
    <a href="${pageContext.request.contextPath}/homepage"><input type="submit" value="Back to home-page" ></a>
    <a href="${pageContext.request.contextPath}/website/list"><input type="submit" value="Back to List" ></a>
</div>
</body>


</html>