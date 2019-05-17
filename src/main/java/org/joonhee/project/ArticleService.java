package org.joonhee.project;

/*Check*/
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArticleService {

	static final Logger logger = LogManager.getLogger();

	@Autowired
	ArticleDao articleDao;

	public void insertArticle() {
		Article article = new Article();
		articleDao.insert(article);
		logger.debug("Enter");
	}
}
