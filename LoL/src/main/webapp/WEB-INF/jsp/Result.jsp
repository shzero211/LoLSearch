<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>랭크검색</title>
</head>

<body>
<h2>찾은사람의 정보는?</h2>
<p>${summoner.name}</p>
<p>LV.${summoner.getSummonerLevel()}</p>
<p>티어:${leagueInfo.getTier()} ${leagueInfo.getRank()}</p> 
<img alt="아이콘" src=${profileImgURL} >
<img  alt="이미지" src=${tierImgURL}>

</body>
</html>