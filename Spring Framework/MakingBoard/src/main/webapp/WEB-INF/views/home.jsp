<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/boardList.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
	rel="stylesheet">

<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<title>Home</title>
</head>
<body>
	<div class="container">

		<div class="table-responsive">
			
			<table class="table table-hover ">
				<thead>
					<tr class="text-center">
						<th scope="col" style="width: 10%;">번호</th>
						<th scope="col" style="width: 55%;">제목</th>
						<th scope="col" style="width: 15%;">작성자</th>
						<th scope="col" style="width: 15%;">작성일</th>
						<th scope="col" style="width: 20%;">조회수</th>
					</tr>
				</thead>

				<c:forEach var="bDto" items="${list}">

					<tr class="text-center">
						<td scope="col" style="width: 10%;">${bDto.num}</td>
						<td scope="col" style="width: 55%;"><a
							href="${pageContext.request.contextPath}/BoardView?num=${bDto.num}">
								${bDto.subject} </a></td>
						<td scope="col" style="width: 15%;">${bDto.writer}</td>
						<td scope="col" style="width: 15%;">${bDto.reg_date}</td>
						<td scope="col" style="width: 20%;">${bDto.readCount}</td>

					</tr>
				</c:forEach>

			</table>
			<a
				href="${pageContext.request.contextPath}/BoardWrite"><button
					type="button" class="btn btn-primary" data-bs-toggle="modal"
					data-bs-target="#exampleModal">글쓰기</button></a>

		</div>
	</div>
</body>
</html>
