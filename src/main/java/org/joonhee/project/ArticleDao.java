package org.joonhee.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class ArticleDao{

	static final String INSERT = "INSERT article(title,content,userId,name) VALUES(?,?,?,?)";
	static final String SELECT_ALL = "SELECT articleId, title, userId, name, left(cdate,19) cdate FROM article ORDER BY articleId desc LIMIT ?,?";
	static final String COUNT_ALL = "SELECT count(articleId) count FROM article";
	static final String DETAIL = "SELECT * FROM article where articleId = ?";
	
	@Autowired
	JdbcTemplate jdbcTemplate;

   RowMapper<Article> articleRowMapper = new BeanPropertyRowMapper<>(Article.class);
	
	public int insert(Article article) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(INSERT,article.getTitle(),article.getContent(),article.getUserId(),article.getName());
	}

	public List<Article> selectAll(int offset, int count) {
		return jdbcTemplate.query(SELECT_ALL, articleRowMapper, offset, count);
	}

	public int countAll() {
		return jdbcTemplate.queryForObject(COUNT_ALL, Integer.class);
	}
	
	public Article getBoard(int articleId) {
		return jdbcTemplate.queryForObject(DETAIL, articleRowMapper, articleId);
	}
	
}
