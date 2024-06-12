<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport"
    content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1">

<link rel="stylesheet"
    href="${pageContext.request.contextPath}/css/boardView.css">

<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet"
    href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap">
<link rel="stylesheet"
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
    rel="stylesheet">

<title>Board View</title>

<style>
    /* 모달 스타일 */
    .modal {
        display: none; /* 초기에는 숨김 */
        position: fixed;
        z-index: 1000;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        background-color: rgba(0,0,0,0.4);
    }

    /* 모달 내용 스타일 */
    .modal-content {
        background-color: #fefefe;
        margin: auto; /* 화면 중앙에 위치 */
        padding: 20px;
        border: 1px solid #888;
        width: 60%; /* 모달 너비 조정 */
        max-width: 500px; /* 최대 너비 설정 */
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.2);
    }

    /* 닫기 버튼 스타일 */
    .close {
        color: #aaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
    }

    .close:hover,
    .close:focus {
        color: black;
        text-decoration: none;
        cursor: pointer;
    }

    /* 모달 내용 스타일 */
    #deleteModalContent {
        margin-top: 50px; /* 모달 내용이 화면 중앙에 위치하도록 조정 */
    }
</style>
</head>
<body>
    <div class="container">
        <div class="row" id="qWriteView">
            <div class="col-12">
                <table class="table table-bordered table-striped">
                    <thead>
                        <c:forEach var="bDto" items="${list}">
                            <tr id="qWriteViewTable">
                                <td colspan="7" style="font-weight: bold;">제목: ${bDto.subject}</td>
                            </tr>
                            <tr id="qWriteViewTable">
                                <td style="width: 10%; font-weight: bold;">작성자</td>
                                <td colspan="2">${bDto.writer}</td>
                                <td style="width: 10%; font-weight: bold;">작성일자</td>
                                <td colspan="2">${bDto.reg_date}</td>
                                <td style="width: 10%; font-weight: bold;">조회수</td>
                                <td>${bDto.readCount}</td>
                            </tr>
                            <tr id="qWriteViewTable" style="height: 400px;">
                                <td style="font-weight: bold; vertical-align: middle;">내용</td>
                                <td colspan="6" style="vertical-align: middle;">${bDto.content}</td>
                            </tr>
                        </c:forEach>
                    </thead>
                </table>
            </div>
        </div>
        <div class="qWriteViewButton">
            <!-- 삭제 버튼 -->
            <input type="password" id="passwordInput" placeholder="비밀번호 입력">
            <c:forEach var="bDto" items="${list}">
                <button onclick="deletePost('${bDto.num}')">삭제</button>
                <!-- 수정 버튼 -->
                <button onclick="goToUpdatePage('${bDto.num}')">수정</button>
            </c:forEach>
            <a href="${pageContext.request.contextPath}/"><button>목록</button></a>
        </div>
    </div>
    
    <script>
        // 삭제 요청 처리
        function deletePost(num) {
            var password = document.getElementById('passwordInput').value;

            // 비밀번호 입력 확인
            if (!password) {
                alert("비밀번호를 입력하세요.");
                return;
            }
    
            // 삭제 요청
            location.href = '${pageContext.request.contextPath}/BoardDelete?num=' + num + '&password=' + password;
        }
    
        // 수정 페이지로 이동
        function goToUpdatePage(num) {
            var password = document.getElementById('passwordInput').value;

            // 비밀번호 입력 확인
            if (!password) {
                alert("비밀번호를 입력하세요.");
                return;
            }
            
            location.href = '${pageContext.request.contextPath}/BoardWriteEdit?num=' + num + '&password=' + password;
        }
    </script>
    
</body>
</html>
