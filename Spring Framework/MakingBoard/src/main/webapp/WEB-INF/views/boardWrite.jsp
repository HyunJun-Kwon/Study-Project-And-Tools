<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/boardWrite.css">

<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<!-- <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css"> -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
    <form
		action="${pageContext.request.contextPath}/BoardWriteCheck"
		method="post">

		<div class="container">
			<div class="row" id="qWrite">
				<table>
					<div class="col-12">
						<tr id="qWriteTable">
							<td id="qWriteTableName">작성자</td>
							<td><input type="text" name="writer" required id="inputType"></td>
							<!--    readonly="readonly" value="${loggedInUser.name }" -->
						</tr>
						<tr id="qWriteTable">
							<td id="qWriteTableName">제목</td>
							<td><input type="text" name="subject" required
								id="inputType"></td>
						</tr>
						<tr id="qWriteTable">
							<td id="qWriteTableName">비빌번호</td>
							<td><input type="password" name="password" required
								id="inputType"></td>
						</tr>
						<tr id="qWriteTable">
							<td id="qWriteTableName">글내용</td>
							<td><textarea placeholder="내용을 입력해주세요" required
									name="content"></textarea></td>
						</tr>
					</div>
				</table>
			</div>

            <div class="qWBottom">
                <button type="submit" class="btn btn-primary">확인</button>
                <a
				href="${pageContext.request.contextPath}/"><button
					type="button" class="btn btn-primary" >취소</button></a>
            </div>
		</div>

		
	</form>
</body>
</html>