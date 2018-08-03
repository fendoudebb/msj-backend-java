package com.msj.blog.entity.domain.article;

import com.msj.blog.entity.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

/**
 * 文章所属模块
 * 如IT模块,常识模块等
 */
@Setter
@Getter
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "article_module",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class ArticleModule extends BaseEntity {

    private static final long serialVersionUID = 2205376374916451004L;
    private Integer sort;//模块排序
    private String name;//模块名字
    private String alias;//别名

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ArticleCategory articleCategory;

    @OneToMany(mappedBy = "articleModule")
    private Set<Article> articles;

}

