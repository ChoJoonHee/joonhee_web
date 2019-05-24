package org.joonhee.project;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joonhee.book.chap11.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ArticleController {

	@Autowired
	ArticleDao articleDao;


	static final Logger logger = LogManager.getLogger();
	
	@RequestMapping("/register")
	public String addForm(HttpSession session)
	{
		Object memberObj = session.getAttribute("MEMBER");
		if(memberObj == null)
			return "redirect:/app/loginForm";
		else
		return "register";
	}
	
	@PostMapping("/articlelist")
	public String registerComplete(HttpSession session, Article article, 
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model){
		Object memberObj = session.getAttribute("MEMBER");
		if(memberObj == null)
			return "redirect:/app/loginForm";
		
		Member member = (Member) memberObj;
		article.setUserId(member.getMemberId());
		article.setName(member.getName());
		articleDao.insert(article);
		// 페이지 당 가져오는 행의 수
				final int COUNT = 100;
				// 시작점
				int offset = (page - 1) * COUNT;

				List<Article> articleList = articleDao.selectAll(offset, COUNT);

				int totalCount = articleDao.countAll();

				model.addAttribute("totalCount", totalCount);
				model.addAttribute("articlelist", articleList);
				return "articlelist";
		
	}
	

	

	@GetMapping("/articlelist")
	public String articlelist(
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model) {

		// 페이지 당 가져오는 행의 수
		final int COUNT = 100;
		// 시작점
		int offset = (page - 1) * COUNT;

		List<Article> articleList = articleDao.selectAll(offset, COUNT);

		int totalCount = articleDao.countAll();

		model.addAttribute("totalCount", totalCount);
		model.addAttribute("articlelist", articleList);
		return "articlelist";
	}
	
		@RequestMapping(value ="/content", method=RequestMethod.GET)
	    public String content(
	    		@RequestParam("articleId") int articleId, 
	    		Model model )  {
	
		 	Article article = articleDao.getBoard(articleId);
		 	model.addAttribute("article", article);
		 	return "content";
	 }
}