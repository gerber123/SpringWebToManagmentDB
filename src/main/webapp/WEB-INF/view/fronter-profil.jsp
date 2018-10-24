<%--
  Created by IntelliJ IDEA.
  User: gerber
  Date: 22.10.2018
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fronter-Details</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}../resources/css/profile-page.css"/>
    <link href="https://fonts.googleapis.com/css?family=Cinzel" rel="stylesheet">
</head>
<body>
<%--<h1 style="font-size:55px"><span style="color:white">Welcome</span><span style="color:red"> ${user.firstName}</span><span style="color:white">!</span></h1>--%>
    <div class="box">

        <img src="${pageContext.request.contextPath}/resources/images/profile.jpg" class="avatar">
        <h1>Person Details</h1>
        <span style="color:red">Name: </span>${user.firstName}
        <br>
        <span style="color:red">SurName:</span> ${user.lastName}
        <br>
        <span style="color:red">Role: </span>${user.roles}
        <br>
        <span style="color:red">Email:</span> ${user.email}
        <br>
        <span style="color:red">Last Vote Date:</span> ${user.last_vote_date}

        <h1>Website Details</h1>
        <span style="color:yellow">Theme: </span>${website.theme}
        <br>
        <span style="color:yellow">Website-url:</span> <a href="http://${website.website_url}" target="_blank">${website.website_url}</a>
        <br>
        <span style="color:yellow">Vote Points: </span>${website.vote_points}
        <br>
        <span style="color:yellow">Ranking Place: </span>${placeOfRanking}
        <br>

        <a href="${pageContext.request.contextPath}/website/list"><input type="submit" value="Ranking" ></a>
        <a href="${pageContext.request.contextPath}/homepage"><input type="submit" value="Home-Page" ></a>
        <a href="${pageContext.request.contextPath}/website/showFormForEmail?websiteId=${website.id}"><input type="submit" value="Email" ></a>

    </div>

</body>
</html>
