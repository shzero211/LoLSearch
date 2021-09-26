<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<body>
	<nav class="navbar sticky-top  navbar-dark bg-dark">
		<a class="navbar-brand" href="/">Rank.gg</a>
		<form action="/search" method="GET">
			<div class="nav-embed-submit-field">
				<input type="text" placeholder="당신의 아이디를 검색하세요" name="username">
				<button type="submit">검색!</button>
			</div>
		</form>

	</nav>

	<div class="container-fluid h-50 w-75" style="height: 100vh;">
		<div class="row h-100 justify-content-center align-items-center">
			<div class="col-md-3"></div>
			<div class="col-md-3">
				<img src="Logo/Logo.png">
			</div>
			<div class="col-md-3"></div>
		</div>

		<div class="container-fluid h-50 w-75"" >
			<div class="row h-100 justify-content-center align-items-center">
				<div class="col">
					<form action="/search" method="GET">
					<div class="embed-submit-field">
						<input class="form-control" type="text" placeholder="당신의 아이디를 검색하세요." name="username" >
						<button type="submit" >검색</button>
						</div>
					</form>
				</div>

			</div>

		</div>
	</div>
	<%@include file="footer.jsp"%>