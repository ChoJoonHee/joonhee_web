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
	<h2>글 보기</h2>
	<p>
		<a href="./app/article/list">글 목록</a>
	</p>
	<hr />
	<p>
		<span>${article.articleId }</span> | <span style="font-weight: bold;">${article.title }</span>
	</p>
	<p>
		<span>${article.cdate }</span> | <span>${article.name }</span>
	</p>
	<hr />
	<p>${article.contentHtml }</p>
<hr />
		
		<button type="submit"  onclick="location.href='/board/app/articlelist.jsp' ">return to list</button>
		
		
</body>
</html>