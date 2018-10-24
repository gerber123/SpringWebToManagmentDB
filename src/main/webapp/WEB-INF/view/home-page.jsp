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
    <div id="container">
    <%--<div class="leftbox" style="left:16%" >--%>
        <%--<security:authorize access="hasRole('EMPLOYEE')">--%>
        <%--<div class="box" style="opacity:0 ;width:150px"></div>--%>
        <%--</security:authorize>--%>
        <div class="box" style="opacity:0 ;width:280px"></div>
        <div class="box">
        <img src="${pageContext.request.contextPath}/resources/images/profile.jpg" class="avatar">
        <h1>Profile</h1>
        <h3>Information about your profile and your website </h3>
        <a href="${pageContext.request.contextPath}/user/user-detail"><input type="submit" value="Your Profile" ></a>
    </div>



    <%--<div class="leftbox" style="left:37%" >--%>
        <div class="box" style="opacity:0 ;width:2px"></div>
        <div class="box">
        <img src="${pageContext.request.contextPath}/resources/images/ranking.jpg" class="avatar">
        <h1>Ranking!</h1>
        <h3>Check the ranking of websites and cast your vote</h3>
        <a href="${pageContext.request.contextPath}/website/list"><input type="submit" value="Check Ranking" style="margin-bottom:30px" ></a>
    </div>

    <div class="box" style="opacity:0 ;width:2px"></div>
        <div class="box">
        <img src="${pageContext.request.contextPath}/resources/images/register.jpg" class="avatar">
        <h1>Register!</h1>
        <h3>Take part in the competition and register your website</h3>
        <a href="${pageContext.request.contextPath}/website/showFormForRegister"><input type="submit" value="Register Website" ></a>
    </div>
        <div class="box" style="opacity:0 ;width:2px"></div>
    <security:authorize access="hasAnyRole('MANAGER','ADMIN')">
    <%--<div class="rightbox" style="left:40%; top:80%">--%>
        <div class="box">
        <img src="${pageContext.request.contextPath}/resources/images/settings.jpg" class="avatar">
        <h1>Managment</h1>
        <h3>Manage users, delete, adds, bans, change permits etc. Only Admin(*)</h3>
        <a href="${pageContext.request.contextPath}/user/list"><input type="submit" value="Managment Users" ></a>
    </div>
        <div class="box" style="opacity:0 ;width:280px"></div>
    </security:authorize>
    </div>
</body>
</html>
