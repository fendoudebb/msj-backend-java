package com.msj.blog.entity.vo.article;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * zbj: created on 2018/6/18 20:05.
 */
@Data
public class ArticleUIPageVo implements Serializable{
    private static final long serialVersionUID = 6836629346278301150L;

    private Long id;
    private String title;
    private String author;
    private String description;
    private boolean original;//是否原创
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
//    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private LocalDateTime createTime;
    private String articleCategory;
    private String articleCategoryAlias;
}
