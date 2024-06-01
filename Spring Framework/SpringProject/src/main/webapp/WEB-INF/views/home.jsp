<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>HomeBoard List</h1>
	<table>
		<c:forEach var="list" items="${homeList}">
			<tr>
				<td style="width: 10%;">${list.admCd }</td>
				<td style="width: 10%;">${list.regionName }</td>
				<td style="width: 10%;">${list.regionNameDetail }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
