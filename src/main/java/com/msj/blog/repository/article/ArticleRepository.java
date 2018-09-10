package com.msj.blog.repository.article;

import com.msj.blog.entity.domain.article.Article;
import com.msj.blog.entity.domain.category.SecondaryCategory;
import com.msj.blog.entity.domain.enu.ArticleProperty;
import com.msj.blog.entity.domain.enu.AuditStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>, PagingAndSortingRepository<Article, Long> {

    Optional<Article> findByIdAndAuditStatusEqualsAndArticlePropertyEquals(Long id, AuditStatus auditStatus, ArticleProperty articleProperty);

    Page<Article> findAllByArticlePropertyEquals(ArticleProperty articleProperty, Pageable pageable);

    Page<Article> findAllByArticlePropertyIsNot(ArticleProperty articleProperty, Pageable pageable);

    Page<Article> findAllByAuditStatusEqualsAndArticlePropertyEqualsOrderByIdDesc(AuditStatus auditStatus, ArticleProperty articleProperty, Pageable pageable);

    Page<Article> findBySecondaryCategoryAndAuditStatusEqualsAndArticlePropertyEquals(SecondaryCategory secondaryCategory, AuditStatus auditStatus, ArticleProperty articleProperty, Pageable pageable);

    Slice<Article> findAllByAuditStatusEqualsAndArticlePropertyEquals(AuditStatus auditStatus, ArticleProperty articleProperty, Pageable pageable);

    Slice<Article> findAllByAuditStatusEqualsAndArticlePropertyEqualsAndSecondaryCategory_NameEquals(AuditStatus auditStatus, ArticleProperty articleProperty, String secondaryCategoryName, Pageable pageable);

}
