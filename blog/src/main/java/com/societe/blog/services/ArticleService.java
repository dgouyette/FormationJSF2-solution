package com.societe.blog.services;


import com.societe.blog.domain.Article;
import com.societe.blog.domain.Commentaire;

import java.util.List;

public interface ArticleService {

    List<Article> findAllArticle();

    Article findArticleById(long id);

    void removeArticle(Article article);

    void saveArticle(Article article);

    void updateArticle(Article currentArticle);

    void saveCommentaire(Commentaire currentCommentaire);
}
