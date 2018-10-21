<html>

<head>
	<title>Vote Denied</title>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/form-page.css"/>
	<link href="https://fonts.googleapis.com/css?family=Cinzel" rel="stylesheet">
</head>

<body>
<div class="box">
	<img src="${pageContext.request.contextPath}/resources/images/error.jpg" class="avatar">
	<h1>Fail!</h1>
	<h3>You must wait <br>${TimeToNextVoteInHours}:${TimeToNextVoteInMinutes} h <br>To Next Vote <br>Be Patient!</h3>
	<a href="${pageContext.request.contextPath}/homepage"><input type="submit" value="Back to home-page" ></a>
	<a href="${pageContext.request.contextPath}/website/list"><input type="submit" value="Back to List" ></a>

</div>


</body>

</html>