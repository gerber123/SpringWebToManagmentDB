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
          href="${pageContext.request.contextPath}../resources/css/email-page.css"/>
    <link href="https://fonts.googleapis.com/css?family=Cinzel" rel="stylesheet">
</head>
<body>
<%--<h1 style="font-size:55px"><span style="color:white">Welcome</span><span style="color:red"> ${user.firstName}</span><span style="color:white">!</span></h1>--%>
<div class="box">

    <img src="${pageContext.request.contextPath}/resources/images/profile.jpg" class="avatar">
    <h1>Email Details</h1>


    <form:form action="sendEmail" modelAttribute="email" method="POST">
    <span style="color:red">Sender:</span>

        <form:input path="authorName" value="${userWriter.email}"/><form:errors path="authorName" cssClass="error" /><br>
    <span style="color:red">Receiver: </span>

        <form:input  path="reciverEmail" value="${userReceiver.email}"/><form:errors path="reciverEmail" cssClass="error" /><br>
        <span style="color:red"> Theme: </span>

        <form:input type="text" path="themeEmail" /><form:errors path="themeEmail" cssClass="error" /><br><br>
        <span style="color:red">  Text Of Email:</span>
        <form:errors path="textEmail" cssClass="error" />
        <form:textarea name="textOfEmail" rows="5" cols="30"  path="textEmail"/>
        <center><input type="submit" value="Send Email" ></center>
    </form:form>
    <a href="${pageContext.request.contextPath}/website/list">Back to the list</a><br>
    <a href="${pageContext.request.contextPath}/homepage">Back to the Home-page</a><br>
    <a href="${pageContext.request.contextPath}/website/user-detail?websiteId=${userReceiver.websites.id}">Back to <span style="color:yellow">${userReceiver.firstName}</span> profile</a>

    <%--<a href="${pageContext.request.contextPath}/website/showFormForEmail?websiteId=${website.id}"><input type="submit" value="Email" ></a>--%>

</div>

</body>
</html>
