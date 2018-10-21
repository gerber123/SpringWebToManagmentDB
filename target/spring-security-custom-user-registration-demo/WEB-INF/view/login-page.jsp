<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login-TestFront</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}../resources/css/form-page.css"/>
    <link href="https://fonts.googleapis.com/css?family=Cinzel" rel="stylesheet">
</head>
<body>

    <div class="box">

        <c:if test="${param.logout==null&& param.error==null}">
            <img src="${pageContext.request.contextPath}/resources/images/avatar.jpg" class="avatar">
            <h1>Login <span style="color:red">Here</span></h1>
        </c:if>

        <c:if test="${param.error != null}">

            <div class="errorMsg">
                <img src="${pageContext.request.contextPath}/resources/images/error.jpg" class="avatar"><br><h1>Invalid data!</h1>
            </div>

        </c:if>

        <!-- Check for logout -->

        <c:if test="${param.logout != null}">

            <div class="errorMsg">
                <img src="${pageContext.request.contextPath}/resources/images/logout.jpg" class="avatar"><br> <h1>Logged Out!</h1>
            </div>


        </c:if>
        <form action="${pageContext.request.contextPath}/authenticateTheUser"
              method="POST" class="form-horizontal">

            <p>Username</p>
            <input type="text" name="username" placeholder="Enter UserName">
            <p>Password</p>
            <input type="password" name="password" placeholder="Enter password">

            <input type="submit" value="login"/>
            <a href="${pageContext.request.contextPath}register/showRegistrationForm">Don't Have Account?</a>


            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
        </form>

    </div>
</body>
</html>
