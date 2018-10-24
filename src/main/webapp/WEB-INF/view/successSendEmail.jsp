<html>

<head>
	<title>Website Confirmation</title>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/form-page.css"/>
	<link href="https://fonts.googleapis.com/css?family=Cinzel" rel="stylesheet">
</head>

<body>

	<div class="box">


		<img src="${pageContext.request.contextPath}/resources/images/email.jpg" class="avatar">
		<h1>Success!</h1>
		<h3>The email was sent correctly! You can go back to homepage </h3>
		<a href="${pageContext.request.contextPath}/homepage"><input type="submit" value="HomePage" ></a>
		<a href="${pageContext.request.contextPath}/website/list"><input type="submit" value="Ranking" ></a>

	</div>
</body>

</html>