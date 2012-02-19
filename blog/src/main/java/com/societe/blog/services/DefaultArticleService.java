package com.societe.blog.services;

import com.societe.blog.domain.Article;
import com.societe.blog.domain.Commentaire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
@Transactional
public class DefaultArticleService implements ArticleService {


    private final static Logger LOGGER = LoggerFactory.getLogger(DefaultArticleService.class);

    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }


    @Override
    public List<Article> findAllArticle() {
        LOGGER.debug("Recuperation de tous les articles");
        return em.createQuery("select a from Article a").getResultList();
    }

    @Override
    public Article findArticleById(final long id) {
        LOGGER.debug("articleId {}", id);
        return em.find(Article.class, id);
    }

    @Override
    public void removeArticle(Article article) {
        LOGGER.debug("Suppression de {}", article);
        em.remove(em.merge(article));
    }


    @Override
    public void saveArticle(Article article) {
        LOGGER.debug("article {}", article);
        em.persist(article);
    }

    @Override
    public void updateArticle(Article article) {
        LOGGER.debug("article {}", article);
        em.persist(em.merge(article));
    }

    @Override
    public void saveCommentaire(Commentaire commentaire) {
        LOGGER.debug("commentaire {}", commentaire);
        em.persist(commentaire);
    }
}
