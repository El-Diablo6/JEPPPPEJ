<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Parcel Management - Login</title>
<link rel="stylesheet" href="./CSS/login.css">
</head>

<body>



	<div class="login-container">
		<div class="login-header">
			<%
			if (error != null) {
			%>
			<h1>login failed!</h1>
			<%
			}
			%>
			<h1>Parcel Management</h1>
		</div>
		<form id="loginForm" action="LoginServlet" method="post">
			<div class="form-group">
				<label for="username">User ID:</label> <input type="text"
					id="username" name="username" minlength="5" maxlength="20" required>
				<p id="usernameError" class="error-message"></p>
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					id="password" name="password" maxlength="30" required>
				<p id="passwordError" class="error-message"></p>
			</div>
			<div class="form-group">
				<button type="submit" name="action" value="Login">Log In</button>
			</div>
			<div class="form-group">
				<p id="generalError" class="error-message"></p>
			</div>

			<div>
				<p>
					Don't have an account?<span><a href="registration.jsp">Sign
							up</a></span>
				</p>

			</div>
		</form>
	</div>
	<script src="./JavaScript Files/login.js"></script>
</body>

</html>
