package com.inventory.inventory.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.inventory.inventory.dto.Article;
import com.inventory.inventory.exception.ArticleNotFoundException;

@RestController
@RequestMapping(path="/api/article/")
public class ArticleController {

	private HashMap<Integer, Article> articleMap;
	private static final Logger logger = LogManager.getLogger(ArticleController.class);
	
	{
		articleMap = new HashMap<>();
		Article artical1 = new Article();
		artical1.setArticleId(220);
		artical1.setTaxRate(12);
		artical1.setArticleCode("SW10001");
		artical1.setPrice(new BigDecimal("35.99"));
		artical1.setQuantity(1);
		artical1.setArticleName("Versandkostenfreier Artikel");
		
		Article artical2 = new Article();
		artical2.setArticleId(221);
		artical2.setTaxRate(18);
		artical2.setArticleCode("SW12345");
		artical2.setPrice(new BigDecimal("42.99"));
		artical2.setQuantity(1);
		artical2.setArticleName("Versandkostenfreier Artikel");
		
		Article artical3 = new Article();
		artical3.setArticleId(232);
		artical3.setTaxRate(5);
		artical3.setArticleCode("SW9999");
		artical3.setPrice(new BigDecimal("10.99"));
		artical3.setQuantity(1);
		artical3.setArticleName("Versandkostenfreier Artikel");
		
		articleMap.put(220, artical1);
		articleMap.put(221, artical2);
		articleMap.put(232, artical3);
	}
	
	@GetMapping("{articleId}")
	public Article getArticle(@PathVariable int articleId) {
		Article article = articleMap.get(articleId);
		
		if(article == null) {
			logger.debug("Article not found for given id : - " + articleId);
			throw new ArticleNotFoundException();
		}
		
		logger.debug("Article found for given id : - " + articleId);
		return article;
	}
	
	
}
