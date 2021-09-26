<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!doctype html>
<html lang="kr">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

	<link rel="stylesheet" href="css/embed.css">
    <title>Rank.gg에오신것을 환영합니다.</title>
  </head>
  
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