package com.charon.boot.controller;

import com.charon.boot.mapper.ArticleMapper;
import com.charon.boot.model.AjaxResponse;
import com.charon.boot.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Slf4j
@RestController
@RequestMapping("/rest")
public class  ArticleRestController {

    @Autowired
    private ArticleMapper articleMapper;
    /**
     * 以post请求方式添加数据
     * @param article
     * @return
     */
    @RequestMapping(value = "/article", method = POST, produces = "application/json")
    public AjaxResponse saveArticle(@RequestBody Article article) {
        log.info("saveArticle：{}",article);
        articleMapper.saveArticle(article);
        return  AjaxResponse.success(article);
    }

    /**
     * delete请求删除数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/article/{id}", method = DELETE, produces = "application/json")
    public AjaxResponse deleteArticle(@PathVariable Long id) {
        log.info("deleteArticle：{}",id);
        return AjaxResponse.success(id);
    }

    /**
     * put请求修改数据
     * @param id
     * @param article
     * @return
     */
    @RequestMapping(value = "/article/{id}", method = PUT, produces = "application/json")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);
        log.info("updateArticle：{}",article);
        return AjaxResponse.success(article);
    }

    /**
     * get请求获取数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    public AjaxResponse getArticle(@PathVariable Long id) {
        //Article article = Article.builder().id(1L).author("charon").content("spring boot").createTime(new Date()).title("t1").build();
        Article article = articleMapper.getArticleById(id);
        return AjaxResponse.success(article);
    }
}
