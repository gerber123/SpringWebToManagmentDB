<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User-Edit</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/form-page.css"/>
    <link href="https://fonts.googleapis.com/css?family=Cinzel" rel="stylesheet">
</head>
<body>

<div class="box">


    <img src="${pageContext.request.contextPath}/resources/images/avatar.jpg" class="avatar">
    <h1>Register <span style="color:red">Here!</span> </h1>



    <form:form action="saveUser" modelAttribute="User" method="post">
        <input:hidden path="id"/>
        <input:hidden path="password"/>
        <input:hidden path="voteEnable" />
        <input:hidden path="userName"/>


        <c:if test="${registrationError != null}">
            <div class="errorMsg">
                    ${registrationError}
            </div>
        </c:if>



        <p>FirstName
            <form:errors path="firstName" cssClass="error" /></p>
        <form:input path="firstName" placeholder="first name (*)" class="form-control" />

        <p>LastName
            <form:errors path="lastName" cssClass="error" /></p>
        <form:input path="lastName" placeholder="last name (*)" class="form-control" />

        <p>Email
            <form:errors path="email" cssClass="error" /></p>
        <form:input path="email" placeholder="theme (*)" class="form-control" />

          <p>Actual Role:</p>
              <form:select path="roles" items="${rolesOption}" multiple="false" cssClass="styled-select"/>

          <%--<p>Website:</p>--%>
        <%--<form:input path="websites" placeholder="website" value="${User.websites.id}" class="form-control" />--%>
            <%--<p>Date</p>--%>
                <%--<form:input path="last_vote_date" item="${dateOfLastVote}"/>--%>
        <%--&lt;%&ndash;<p>Actual Role: ${User.roles}&ndash;%&gt;--%>

            <%--<form:select path="roles" class="form-control" >--%>
                <%--<form:options items="${rolesOption}" />--%>
            <%--</form:select>--%>



        <input type="submit" value="Register"/>
        <a href="${pageContext.request.contextPath}/user/list">Back to User list</a>

        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form:form>

</div>
</body>
</html>
