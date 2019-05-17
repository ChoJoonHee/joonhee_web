<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>회원 목록</title>
</head>
<body>
	<p>전체 ${totalCount }건</p>
	<form action="./app/articlelist">
		<input type="number" name="page" value="${param.page }" placeholder="페이지"
			min="1" max="${totalCount / 100 + 1 }" step="1" style="width: 50px;">
		<button type="submit">조회</button>
		<button type="button" value="글 등록"  onclick="location.href='/board/app/register.jsp' ">글 등록</button>
	</form> 
	<table>
		<thead>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>등록일시</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="article" items="${articlelist}" varStatus="articleId">
				<tr>
					<td>${article.articleId }</td>
					<td>
					<a href="./app/content?articleId=${article.articleId }">${article.title}</a>
					</td>
					<td>${article.name }</td>
					<td>${article.cdate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</head>
</html>