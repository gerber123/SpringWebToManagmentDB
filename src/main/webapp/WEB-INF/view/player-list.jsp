<%--
  Created by IntelliJ IDEA.
  User: gerber
  Date: 26.09.2018
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Player List</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>FOR THE EXP - LIST OF PLAYERS</h2>
        </div>
    </div>
    <div id="container">
        <div id="content">
            <input type="button" value="Register"
                   onclick="window.location.href='showFormForRegister';return false;"
                   class="add-button"
            />

            <input type="button" value="Refresh"
                   onclick="window.location.href='refresh';return false;"
                   class="add-button"
            />
            <input type="button" value="Register VIP"
                   onclick="window.location.href='showFormForRegisterVIP';return false;"
                   class="add-button"
            />
            <form:form action="search" method="POST">
                Search Player: <input type="text" name="nameOfPlayer"/>
                <input type="submit" value="Find Him!">
            </form:form>
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Last Modification </th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            <c:forEach var="temp" items="${players}">
                <c:url var="updateLink" value="/player/showFormForUpdate">
                    <c:param name="playerId" value="${temp.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/player/deletePlayer">
                    <c:param name="playerId" value="${temp.id}"/>
                </c:url>
                <tr>
                    <td>${temp.firstName}</td>
                    <td>${temp.lastName}</td>
                    <td>${temp.email}</td>
                    <td>${temp.date}</td>
                    <td>${temp.status}</td>
                    <td><a href="${updateLink}">Update</a>||
                        <a href="${deleteLink}" onclick="if(!(confirm('Are You Sure you want delete this player?')))return false">Ban&Delete</a></td>
                </tr>

            </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
