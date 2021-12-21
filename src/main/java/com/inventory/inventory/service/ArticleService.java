package com.inventory.inventory.service;

import org.springframework.stereotype.Service;

import com.inventory.inventory.dto.Article;
import com.inventory.inventory.exception.ArticleNotFoundException;
import com.inventory.inventory.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository repository;
	
	public Article get(Long articleId) {
		return repository.findById(articleId).orElseThrow(ArticleNotFoundException::new);
	}
	
	public Article save(Article article) {
		return repository.save(article);
	}
	
	public Article update(Long articleId, Article article) {
		Article articleToUpdate = repository.findById(articleId).orElseThrow(ArticleNotFoundException::new);
		
		articleToUpdate.setTaxRate(article.getTaxRate());
		articleToUpdate.setArticleCode(article.getArticleCode());
		articleToUpdate.setPrice(article.getPrice());
		articleToUpdate.setQuantity(article.getQuantity());
		articleToUpdate.setArticleName(article.getArticleName());
		
		return repository.save(articleToUpdate);
		
	}
}
