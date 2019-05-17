<!doctype html>
<!-- 
p.277 [리스트 11.9] 회원가입 화면
 -->
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>글쓰기</title>
</head>
<body>
	<h2>글쓰기</h2>
	<form action="./app/articlelist" method="post">
		<p>
			제목:<br> <input type="text" name="title" value="${param.title }">
		</p>
		<p>
			내용:<br> <textarea name="content" value="${param.content }"></textarea>
		</p>
		<p>${article.contentHtml }</p>
		<button type="submit">Save</button>
	</form>
</body>
</html>