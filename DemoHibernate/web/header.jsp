
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="stylesheet.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>

<body>
	<div class="container-float">
		<nav class="navbar navbar-custom">
			<div class="row">
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
					<div class="navbar-header">
						<a class="navbar-brand textcolour" href="#">Cimbidia</a>
					</div>
				</div>
				<form action="search.do" method="get">
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12" style="margin-top: 10px;">
					<div class="input-group">
				      <input type="text" class="form-control" placeholder="Search" name="search">
						<div class="input-group-btn">
                            
							<input type="submit" class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i>
						</div>
				    </div>
				</div>
				</form>
			</div>
		</nav>
		<ul class="nav nav-pills nav-justified">
			<li role="presentation"><a href="#">Purchase Order</a></li>
			<li role="presentation"><a href="#">Customer Order</a></li>
			<li role="presentation"><a href="#">ASNs</a></li>
			<li role="presentation"><a href="#">Shipment</a></li>
			<li role="presentation"><a href="#">Bookings</a></li>
			<li role="presentation"><a href="#">Invoice</a></li>
			<li role="presentation"><a href="#">Visibility</a></li>
			<li role="presentation"><a href="#">Cimchat</a></li>
			<li role="presentation"><a href="#">settings</a></li>
		</ul>
	</div>

	<script type="application/javascript">
		function fetchRecords() {
		    var currentValue = $(this).val();
		    if(currentValue.length <= 3)
		        return;
            $.ajax({
                accepts: 'text/html',
				url: '/search?search=' + currentValue
			}).;
        }
	</script>