<%--
  Created by IntelliJ IDEA.
  User: gerber
  Date: 17.10.2018
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Loading...</title>
    <link rel="stylesheet" href="/resources/css/preload.css">
    <link rel="stylesheet"           href="${pageContext.request.contextPath}/resources/css/form-page.css"/>
    >

</head>
<body>
    <div class="preload" id="preload">
        <div class="logo">
            Sending<span style="color:yellow;">Email...</span>
        </div>
        <div class="loader-frame">
            <div class="loader1" id="loader1"></div>
            <div class="loader2" id="loader2"></div>
        </div>
    </div>
    <script src="/resources/scripts/scriptEmail.js"></script>
</body>
</html>
