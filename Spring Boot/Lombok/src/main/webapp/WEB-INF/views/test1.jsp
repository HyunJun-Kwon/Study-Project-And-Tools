<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<mete http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>insert title here</title>
</head>
<body>
<%
	out.println("#01 : Hello World");
%>
<br>
당신의 아이디는 ${member.id} 입니다.<br>
당신의 이름은 ${member.name} 입니다.
</body>
</html>