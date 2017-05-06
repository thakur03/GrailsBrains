<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="stylesheet.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>login</title>
</head>
<body>
	<div class="container">

		<form action="login.do" method="post" class="form-horizontal loginform">
			<br>
			<h3 align="center" class="textcolour" style="margin-top:29px">LOGIN TO YOUR CIMBIDIA ACCOUNT</h3>
			<br>
			<div class="form-group">
				<div class="col-md-offset-2 col-sm-offset-2 col-md-8 col-sm-8">
					<input type="text" class="form-control" name="username" id="username" placeholder="enter username">
				</div>
			</div>
			<br>
			<div class="form-group">
				<div class="col-md-offset-2 col-sm-offset-2 col-md-8 col-sm-8">
					<input type="password" class="form-control" name="password" id="password" placeholder="enter password">
				</div>
			</div>
			<br>
			<div class="form-group">
				<div class="col-md-10">
					<div class="col-md-offset-2 col-md-6">
						<label class="textcolour">Forgot your username or password ?
						<a href="#" class="textcolour">Click to reset</a></label>
					</div>
					<div class="col-md-offset-2 col-md-2">
						<button type="submit" name="login" id="login" class="btn btn-default textcolour" align="right" class="textcolour">LOGIN <span class="glyphicon glyphicon-play"></span></button>
					</div>
				</div>
			</div>
		</form>
	</div>

</body>
</html>