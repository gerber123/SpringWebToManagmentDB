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

    <title>Player List</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>
<body>
<center>
    <div id="wrapper">

        <div id="header">
            <h2><center>FOR THE EXP - LIST OF PLAYERS</center></h2>
        </div>

    </div>
    <div id="container">
        <center>
        <div id="content" >
            <table>
                <tr>
                    <th>First Name</th>
                </tr>

            <c:forEach var="users" items="${users}">


                <tr>
                    <td>${users.userName}</td>
                </tr>

            </c:forEach>

            </table>
        </div>
        </center>
    </div>
</center>
</body>
</html>
