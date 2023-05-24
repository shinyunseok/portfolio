<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title> getBoardList </title>
</head>
<body>
	<c:if test="${empty name}">
	<c:redirect url="login.jsp" />
</c:if>

<c:if test="${empty totalCount}">
	<c:set var="totalCount" value="1" />
</c:if>


<c:choose>
	<c:when test="${empty page }">
		<c:set var="page" value="1" />
	</c:when>
	<c:otherwise>
		<c:set var="page" value="${page }" />
	</c:otherwise>
</c:choose>
	<h2>
		<a href="getUser?id=${id }">${name }</a>님 환영합니다<a href="logout.do">로그아웃</a>
		<br>
	</h2>

	<form action="getBoardList.do?page=1" method="get">
		게시판 검색유형 : <select name="searchCondition">
			<option value="writer">작성자</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select> &nbsp;검색어 : <input type="text" size="20" name="searchKeyword">
		<input type="submit" value="검색">
	</form>

	<br>
	<br>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
		
		<c:forEach items="${boardList }" var="board">
		<tr>
				<td>${board.seq}</td>
				<td><a href="getBoard.do?seq=${board.seq}">${board.title }</a></td>
				<td>${board.writer }</td>
				<td>${board.regDate }</td>
				<td>${board.cnt }</td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<a href="insertBoard.do">새글등록</a>
	
	
	<jsp:include page="getBoardListPage.jsp">
		<jsp:param value="${page }" name="pg" />
		<jsp:param value="${totalCount }" name="totalCount" />
		<jsp:param value="${searchKeyword }" name="searchKeyword" />
		<jsp:param value="${searchCondition }" name="searchCondition" />
	</jsp:include>
	

</body>
</html>