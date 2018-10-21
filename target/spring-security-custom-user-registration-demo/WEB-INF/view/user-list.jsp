<%--
  Created by IntelliJ IDEA.
  User: gerber
  Date: 26.09.2018
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>

    <title>User List</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/list-pages.css"/>
    <link href="https://fonts.googleapis.com/css?family=Cinzel" rel="stylesheet">

</head>
<body>
<center>
    <div id="wrapper">

        <div id="header">
            <h2><center>Website Tournament - <span style="color:red">Check your skill</span></center></h2>
        </div>

    </div>
    <div id="container">
        <center>
            <div id="content" >
                <div id="buttons">
                    <input type="button" value="Refresh" class="button"
                           onclick="window.location.href='refresh';return false;"
                           class="add-button"/>
                    <form:form action="${pageContext.request.contextPath}/homepage" method="get">
                        <input type="submit" value="HomePage" class="button"  >
                    </form:form>
                    <form:form action="${pageContext.request.contextPath}/logout">
                        <input type="submit" value="logout" class="button"  >
                    </form:form>
                </div>

                <div id="textSearch">
                    <form:form action="search" method="POST">
                        Search Author:<input type="text" name="nameOfUser" class="textFinder"/>
                        <input type="submit" value="Find Him!"  class="button" placeholder=" Input name to find">
                    </form:form></div>

                <table>
                    <tr>
                        <th>UserName</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Roles</th>
                        <security:authorize access="hasRole('ADMIN')">
                            <th>Action</th>
                        </security:authorize>
                    </tr>

                    <c:forEach var="temp" items="${users}">

                        <c:url var="updateLink" value="/user/showFormForUpdate">
                            <c:param name="userId" value="${temp.id}"/>
                        </c:url>


                        <c:url var="deleteLink" value="/user/deleteUser">
                            <c:param name="userId" value="${temp.id}"/>
                        </c:url>

                        <tr>
                            <td>${temp.userName}</td>
                            <td>${temp.firstName}</td>
                            <td>${temp.lastName}</td>
                            <td>${temp.email}</td>
                            <td>${temp.roles}</td>
                            <security:authorize access="hasRole('ADMIN')">
                                <td><a href="${updateLink}">Update</a>||
                                    <a href="${deleteLink}" onclick="if(!(confirm('Are You Sure you want delete this website?')))return false">Ban&Delete</a></td>
                            </security:authorize>
                        </tr>

                    </c:forEach>

                </table>
            </div>
        </center>
    </div>
</center>
</body>
</html>
