package com.inventory.inventory.repository;

import org.springframework.stereotype.Repository;

import com.inventory.inventory.dto.Article;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long>{

}
