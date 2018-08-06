package com.msj.blog.entity.vo.article;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ArticleVo implements Serializable{
    private static final long serialVersionUID = -4535144378381183641L;
    private Long id;
    private String title;
    private String author;
    private String keywords;
    private String description;
    private boolean original;//是否原创
    private String originalLink;//原文链接
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private LocalDateTime updateTime;
    private Long articleModuleId;
    private String articleModule;
    private String articleModuleAlias;

}
