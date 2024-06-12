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
<title>Board Write Update</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/BoardWriteUpdateCheck" method="post">
        <c:forEach var="bDto" items="${list}">
            <div class="container">
                <div class="row" id="qWrite">
                    <table>
                        <div class="col-12">
                            <tr id="qWriteTable">
                                <td id="qWriteTableName">작성자</td>
                                <td><span>${bDto.writer}</span></td>
                            </tr>
                            <tr id="qWriteTable">
                                <td id="qWriteTableName">제목</td>
                                <td><input type="text" name="subject" required id="inputType" placeholder="${bDto.subject}"></td>
                            </tr>
                            <tr id="qWriteTable">
                                <td id="qWriteTableName">비밀번호</td>
                                <td><input type="password" name="password" required id="inputType" placeholder="비밀번호를 입력해주세요."></td>
                            </tr>
                            <tr id="qWriteTable">
                                <td id="qWriteTableName">글내용</td>
                                <td><textarea placeholder="내용을 입력해주세요" required name="content">${bDto.content}</textarea></td>
                            </tr>
                        </div>
                    </table>
                </div>
            </div>
            
            <div class="qWBottom">
                <input type="hidden" name="num" value="${bDto.num}">
                <button type="submit" class="btn btn-primary">확인</button>
                <button type="reset" class="btn btn-primary">취소</button>
            </div>
        </c:forEach>
    </form>
    
</body>
</html>