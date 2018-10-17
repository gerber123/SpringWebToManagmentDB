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

    <title>Website List</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <link href="https://fonts.googleapis.com/css?family=Cinzel" rel="stylesheet">

</head>
<body>
<center>
    <div id="wrapper">

        <div id="header">
            <h2><center>Website Tournament - Check your skill</center></h2>
        </div>

    </div>
    <div id="container">
        <center>
        <div id="content" >
            <div id="buttons">
                <input type="button" value="Refresh" class="button"
                       onclick="window.location.href='refresh';return false;"
                       class="button"/>
            <form:form action="${pageContext.request.contextPath}/homepage" method="get">
                <input type="submit" value="HomePage" class="button"  >
            </form:form>
            <form:form action="${pageContext.request.contextPath}/logout">
                <input type="submit" value="logout" class="button"  >
            </form:form>
            </div>

            <div id="textSearch">
            <form:form action="search" method="POST">
                Search Author:<input type="text" name="nameOfAuthor" class="textFinder"/>
                <input type="submit" value="Find Him!"  class="button" placeholder=" Input name to find">
            </form:form></div>

            <table>
                <tr>
                    <th>Author Name</th>
                    <th>Author Surname</th>
                    <th>Theme</th>
                    <th>Website-url</th>
                    <th>Ranking Points</th>
                    <th>Vote</th>
                    <security:authorize access="hasAnyRole('ADMIN','MANAGER')">
                        <th>Action</th>
                    </security:authorize>
                </tr>

            <c:forEach var="temp" items="${websites}">

                <c:url var="updateLink" value="/website/showFormForUpdate">
                    <c:param name="websiteId" value="${temp.id}"/>
                </c:url>


                <c:url var="deleteLink" value="/website/deleteWebsite">
                    <c:param name="websiteId" value="${temp.id}"/>
                </c:url>
                <c:url var="voteLink" value="/website/voteForWebsite">
                    <c:param name="websiteId" value="${temp.id}"/>
                </c:url>

                <tr>
                    <td>${temp.author_firstName}</td>
                    <td>${temp.author_lastName}</td>
                    <td>${temp.theme}</td>
                    <td><a href="http://${temp.website_url}" target="_blank">${temp.website_url}</a></td>
                    <td>${temp.vote_points}</td>
                    <%--<td><input type="button" value="Open Window" onclick="window.open('${temp.website_url}')"> </td>--%>
                    <td><a href="${voteLink}" onclick=" if (!confirm('You can vote once time per day, Are you sure?')) return false;"><img src="/resources/images/voter.png" class="voterImg"/> </a></td>
                    <security:authorize access="hasAnyRole('ADMIN','MANAGER')">
                    <td><a href="${updateLink}">Update</a>&nbsp;||
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
