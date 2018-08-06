package com.msj.blog.controller.admin;

import com.msj.blog.controller.BaseController;
import com.msj.blog.entity.dto.article.ArticleDto;
import com.msj.blog.entity.dto.page.PageDto;
import com.msj.blog.entity.vo.MsgTable;
import com.msj.blog.entity.vo.Response;
import com.msj.blog.entity.vo.article.ArticleVo;
import com.msj.blog.service.article.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.sql.Timestamp;

@Slf4j
@RestController
@RequestMapping("/admin/article")
public class ArticleManageController extends BaseController {

    @Resource
    private ArticleService articleService;

    @PostMapping(value = "/list")
    public Response page(@RequestBody @Valid PageDto pageDto) {
        return getResponse(articleService.findAdminArticleByPage(pageDto.getPage(), pageDto.getSize()));
    }

    @PostMapping(value = "/save")
    public Response save(@RequestBody @Valid ArticleDto articleDto) {
        boolean saveResult = articleService.saveArticle(articleDto);
        return saveResult ? getResponse(MsgTable.SAVE_ARTICLE_SUCCESS) : getResponse(MsgTable.SAVE_ARTICLE_FAILURE).fail();
    }

    @GetMapping(value = "/preview/audit/{id}")
    public ModelAndView articlePreviewAudit(WebRequest webRequest, @PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        ArticleVo articleVo = articleService.getAdminArticleById(id).orElse(null);
        if (articleVo == null) {
            mv.setViewName("error/404");
            return mv;
        }
        if (webRequest.checkNotModified(Timestamp.valueOf(articleVo.getUpdateTime()).getTime())) {
            return null;
        }
        mv.setViewName("article/article");
        mv.addObject("article", articleVo);
        return mv;
    }

    @GetMapping(value = "/preview/edit")
    public ModelAndView articlePreviewEdit(WebRequest webRequest) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("article/article");
        return mv;
    }
}
