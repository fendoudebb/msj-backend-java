package com.msj.blog.service.article;

import com.msj.blog.entity.domain.article.Article;
import com.msj.blog.entity.domain.enu.ArticleProperty;
import com.msj.blog.entity.domain.enu.AuditStatus;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

/**
 * zbj: created on 2018/8/28 21:52.
 */
public interface ArticleBaseService {

    Article saveOrUpdate(Article article);

    Optional<Article> findById(Long id);

    Optional<Article> findByIdAndAuditStatusAndArticleProperty(Long id, AuditStatus auditStatus, ArticleProperty articleProperty);

    Page<Article> findByPage(Integer page, Integer size);

    Page<Article> findByPageAndArticleProperty(ArticleProperty articleProperty, Integer page, Integer size);

    Page<Article> findByPageAndArticlePropertyExclude(ArticleProperty articleProperty, Integer page, Integer size);

    Page<Article> findByPageAndAuditStatusAndArticleProperty(AuditStatus auditStatus, ArticleProperty articleProperty, Integer page, Integer size);

    List<Article> findByAuditStatusAndArticleProperty(AuditStatus auditStatus, ArticleProperty articleProperty);

}