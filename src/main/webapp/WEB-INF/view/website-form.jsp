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

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/entry-page.css"/>
    <link href="https://fonts.googleapis.com/css?family=Cinzel" rel="stylesheet">
</head>
<body>




        <%--<h3>Try your skill!</h3>--%>
    <%--<div id="containerForm">--%>
            <%--<form:form action="saveWebsite" modelAttribute="website" method="post">--%>
                <%--<input:hidden path="id"/>--%>

                <%--<table>--%>
                    <%--<tbody>--%>
                        <%--<tr>--%>
                            <%--<td><label>*First Name: </label></td>--%>
                            <%--<td><form:input path="author_firstName"/> <form:errors path="author_firstName" cssClass="error"/></td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<td><label>*Last Name: </label></td>--%>
                            <%--<td><form:input path="author_lastName"/> <form:errors path="author_lastName" cssClass="error"/></td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<td><label>*Theme: </label></td>--%>
                            <%--<td><form:input path="theme"/>  <form:errors path="theme" cssClass="error"/></td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<td><label>*Website-url: </label></td>--%>
                            <%--<td><form:input path="website_url"/>  <form:errors path="website_url" cssClass="error"/></td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<td><label/></td>--%>
                            <%--<td><input type="submit" value="Confirm" ></td>--%>
                        <%--</tr>--%>
                    <%--</tbody>--%>
                <%--</table>--%>
            <%--</form:form>--%>
        <%--<div style="clear;both;"></div></div>--%>
        <%--<p>--%>
            <%--<a href="${pageContext.request.contextPath}/website/list">Back to The List</a>--%>
        <%--</p>--%>
    <div class="box">


        <img src="${pageContext.request.contextPath}/resources/images/website.jpg" class="avatar">
        <h1>Register Your Website</h1>



        <form:form action="saveWebsite" modelAttribute="website" method="post">
            <input:hidden path="id"/>

            <p>Author Name:
                <form:errors path="author_firstName" cssClass="error" /></p>
            <form:input path="author_firstName" placeholder="First Name(*) " class="form-control" />

            <p>Author Surname:
                <form:errors path="author_lastName" cssClass="error" /></p>
            <form:input path="author_lastName" placeholder="Surname (*)" class="form-control" />

            <p>Theme:
                <form:errors path="theme" cssClass="error" /></p>
            <form:input path="theme" placeholder="Theme (*)" class="form-control" />

            <p>Website Url:
                <form:errors path="website_url" cssClass="error" /></p>
            <form:input path="website_url" placeholder="Website_url(*)" class="form-control" />

            <input type="submit" value="Register"/>
            <a href="${pageContext.request.contextPath}/homepage">Back to HomePage</a>
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
        </form:form>

    </div>

</body>
</html>
