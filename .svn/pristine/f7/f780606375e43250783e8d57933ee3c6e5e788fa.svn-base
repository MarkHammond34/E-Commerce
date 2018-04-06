<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/build-headphones.css">
<title>Build Your Perfect Headphones</title>
</head>
<body>

	<div id="myCarousel" class="carousel-slide slide" data-ride="carousel"
		data-interval="false">

		<div class="carousel-inner" role="listbox">

			<div class="item active">
				<div>
					<h1 style="color: white" align="center">Select A Brand</h1>
				</div>
				<div class="container">
					<div class="row brand-row">

						<div class="col-xs-1"></div>
						<div class="col-md-3">
							<a id="sony"><img src="images/Sony/sony-icon.png"
								alt="Sony Logo" width="300px"></a>
						</div>

						<div class="col-md-3">
							<a id="beats"><img src="images/Beats/beats-icon.png"
								alt="Beats Logo" width="200px"></a>
						</div>

						<div class="col-md-3">
							<a id="bose"><img src="images/Bose/bose-icon.png"
								alt="Bose Logo" width="350px" height="80px"></a>
						</div>

						<div class="col-xs-1"></div>
					</div>
				</div>
			</div>

			<div class="item">
				<div>
					<h1 style="color: white" align="center">Select A Technology</h1>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-sm-1"></div>
						<div class="col-md-5">
							<h3 style="color: white; align: center;">Wired</h3>
							<a id="wired"><img src="images/BuildHeadphones/wired.png"
								class="img-rounded" alt="Sony Logo" width="375px"></a>

						</div>
						<div class="col-sm-1"></div>
						<div class="col-md-5">
							<h3 style="color: white; align: center;">Wireless</h3>
							<a id="wireless"><img
								src="images/BuildHeadphones/wireless.png" class="img-rounded"
								alt="Sony Logo" width="375px"></a>
						</div>
					</div>
				</div>
			</div>

			<div class="item">
				<div>
					<h1 style="color: white" align="center">Select A Style</h1>
				</div>
				<div class="container">
					<div class="row">

						<div class="col-xs-1"></div>
						<div class="col-lg-3">
							<h3 style="color: white; align: center;">In Ear</h3>
							<a id="in-ear"><img src="images/BuildHeadphones/in-ear.png"
								class="img-rounded" alt="In Ear Headphones" width="300px"></a>
						</div>
						<div class="col-xs-1"></div>
						<div class="col-lg-3">
							<h3 style="color: white; align: center;">On Ear</h3>
							<a id="on-ear"><img src="images/BuildHeadphones/on-ear.png"
								class="img-rounded" alt="On Ear Headphones" width="300px"></a>
						</div>

						<div class="col-xs-1"></div>
						<div class="col-lg-3">
							<h3 style="color: white; align: center;">Over Ear</h3>
							<a id="over-ear"><img
								src="images/BuildHeadphones/over-ear.png" class="img-rounded"
								alt="Over Ear Headphones" width="300px"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		var url = "BuildHeadphonesServlet?";

		$(document).ready(function() {
			// Activate Carousel
			$("#myCarousel").carousel();

			// Button clicks for Brand
			$("#sony").click(function() {
				url = url + "brand=sony";
				$("#myCarousel").carousel("next");
			});

			$("#beats").click(function() {
				url = url + "brand=beats";
				$("#myCarousel").carousel("next");
			});

			$("#bose").click(function() {
				url = url + "brand=bose";
				$("#myCarousel").carousel("next");
			});

			// Button clicks for Wireless/Wired
			$("#wireless").click(function() {
				url = url + "&tech=wireless";
				$("#myCarousel").carousel("next");
			});

			$("#wired").click(function() {
				url = url + "&tech=wired";
				$("#myCarousel").carousel("next");
			});

			// Button clicks for Style
			$("#over-ear").click(function() {
				url = url + "&style=over-ear";
				getSearch();
			});

			$("#on-ear").click(function() {
				url = url + "&style=on-ear";
				getSearch();
			});

			$("#in-ear").click(function() {
				url = url + "&style=in-ear";
				getSearch();
			});

		});

		function getSearch() {
			window.location = url;
		}
	</script>
</body>
</html>