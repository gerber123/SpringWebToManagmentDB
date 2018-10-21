<%--
  Created by IntelliJ IDEA.
  User: gerber
  Date: 14.10.2018
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home-page</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}../resources/css/entry-page.css"/>
    <link href="https://fonts.googleapis.com/css?family=Cinzel" rel="stylesheet">
</head>
<body>
    <div id="welcome">Welcome in Tournament of<span style="color:red"> Front-Ender </span>skills</div>
    <security:authorize access="hasAnyRole('MANAGER','ADMIN')">
    <div class="leftbox" style="left:4%" >
        <img src="${pageContext.request.contextPath}/resources/images/website.jpg" class="avatar">
        <h1>Website managment</h1>
        <h3>Managment of websites. Delete, update etc. </h3>
        <a href="${pageContext.request.contextPath}/website/list"><input type="submit" value="Managment Website" ></a>
    </div>
    </security:authorize>

    <div class="leftbox" style="left:27%" >
        <img src="${pageContext.request.contextPath}/resources/images/register.jpg" class="avatar">
        <h1>Register!</h1>
        <h3>Take part in the competition and register your website</h3>
        <a href="${pageContext.request.contextPath}/website/showFormForRegister"><input type="submit" value="Register Website" ></a>
    </div>

    <div class="rightbox" style="left:51%" >
        <img src="${pageContext.request.contextPath}/resources/images/ranking.jpg" class="avatar">
        <h1>Ranking!</h1>
        <h3>Check the ranking of websites and cast your vote</h3>
        <a href="${pageContext.request.contextPath}/website/list"><input type="submit" value="Check Ranking" style="margin-bottom:30px" ></a>
    </div>
    <security:authorize access="hasAnyRole('MANAGER','ADMIN')">
    <div class="rightbox" style="left:73%">
        <img src="${pageContext.request.contextPath}/resources/images/settings.jpg" class="avatar">
        <h1>Users managment</h1>
        <h3>Manage users, delete, add, change permits</h3>
        <a href="${pageContext.request.contextPath}/user/list"><input type="submit" value="Managment Users" ></a>
    </div>
    </security:authorize>
</body>
</html>
