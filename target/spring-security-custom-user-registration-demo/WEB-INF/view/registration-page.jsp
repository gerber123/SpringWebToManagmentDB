<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login Form</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/login-pagecss.css"/>
    <link href="https://fonts.googleapis.com/css?family=Cinzel" rel="stylesheet">
</head>
<body>

    <div class="box">


            <img src="${pageContext.request.contextPath}/resources/images/avatar.jpg" class="avatar">
            <h1>Register Here!</h1>



        <form:form action="${pageContext.request.contextPath}/register/processRegistrationForm"
                   modelAttribute="crmUser"
                   class="form-horizontal">
            <c:if test="${registrationError != null}">
                <div class="errorMsg">
                        ${registrationError}
                </div>
            </c:if>

                <p>UserName
                <form:errors path="userName" cssClass="error" /></p>
                <form:input path="userName" placeholder="username (*)" class="form-control" />

                <p>Password
                <form:errors path="password" cssClass="error" /></p>
                <form:password path="password" placeholder="password (*)" class="form-control" />

                <p>FirstName
                <form:errors path="firstName" cssClass="error" /></p>
                <form:input path="firstName" placeholder="first name (*)" class="form-control" />

                <p>LastName
                <form:errors path="lastName" cssClass="error" /></p>
                <form:input path="lastName" placeholder="last name (*)" class="form-control" />

                <p>Email
                <form:errors path="email" cssClass="error" /></p>
                <form:input path="email" placeholder="theme (*)" class="form-control" />

                <input type="submit" value="Register"/>

            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
        </form:form>

    </div>
</body>
</html>
