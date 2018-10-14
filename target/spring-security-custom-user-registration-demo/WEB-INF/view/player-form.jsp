<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: gerber
  Date: 26.09.2018
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Player Form</title>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>Make your own Account!</h2>
            <link type="text/css"
                  rel="stylesheet"
                  href="${pageContext.request.contextPath}/resources/css/style.css"/>

        </div>
    </div>


        <h3>Save customer</h3>
    <div id="containerForm">
            <form:form action="savePlayer" modelAttribute="player" method="post">
                <input:hidden path="id"/>

                <table>
                    <tbody>
                        <tr>
                            <td><label>*First Name: </label></td>
                            <td><form:input path="firstName"/> <form:errors path="firstName" cssClass="error"/></td>
                        </tr>
                        <tr>
                            <td><label>*Last Name: </label></td>
                            <td><form:input path="lastName"/> <form:errors path="lastName" cssClass="error"/></td>
                        </tr>
                        <tr>
                            <td><label>*Email: </label></td>
                            <td><form:input path="email"/>  <form:errors path="email" cssClass="error"/></td>
                        </tr>
                        <tr>
                            <td><label/></td>
                            <td><input type="submit" value="Confirm" ></td>
                        </tr>
                    </tbody>
                </table>
            </form:form>
        <div style="clear;both;"></div></div>
        <p>
            <a href="${pageContext.request.contextPath}/player/list">Back to The List</a>
        </p>


</body>
</html>
