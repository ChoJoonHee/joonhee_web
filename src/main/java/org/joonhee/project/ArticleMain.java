package org.joonhee.project;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
	
/*Check*/
public class ArticleMain{
	public static void main(String args[]) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("article-context.xml");
		ArticleService articleService = ctx.getBean("articleService", ArticleService.class);
		articleService.insertArticle();
		ctx.close();
	}
}