package com.societe.blog;


import com.google.common.collect.Lists;
import com.societe.blog.domain.Article;
import com.societe.blog.domain.Commentaire;
import com.societe.blog.services.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Named
/**
 * Classe chargeant un jeu de donnes pour le developpement
 */
public class Bootstrap {

    @Inject
    private ArticleService articleService;

    private static final Logger LOGGER = LoggerFactory.getLogger(Bootstrap.class);


    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        LOGGER.debug("*******************************************************************");
        LOGGER.debug("***                                                            ****");
        LOGGER.debug("***      Chargement des donnees du blog                        ****");
        LOGGER.debug("***                                                            ****");
        LOGGER.debug("*******************************************************************");

        Article article = new Article();
        article.setAuteur("Damien GOUYETTE");
        article.setTitre("Ceci est un titre");
        article.setContenu("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec et purus vel sapien pulvinar varius. In hac habitasse platea dictumst. Aliquam tincidunt lorem tempor nulla semper dictum. Cras massa purus, tincidunt in cursus eget, dapibus id metus. Fusce blandit sapien odio, quis fringilla mi. Nunc consequat, enim eu faucibus elementum, urna ligula tincidunt justo, sed rutrum tortor orci sit amet purus. Maecenas faucibus aliquam sapien et ornare. Cras tincidunt est in turpis molestie luctus. Quisque iaculis justo eu ipsum suscipit ac semper neque tempor. Phasellus cursus eros eu mauris varius sollicitudin. Ut sem odio, convallis at consectetur in, blandit vel mi.");
        article.setDateCreation(new Date());
        Commentaire c1 = new Commentaire("Damien GOUYETTE", "Commentaire n°1");
        Commentaire c2 = new Commentaire("Jean DUPOND", "Commentaire n°2");

        List<Commentaire> commentaires = Arrays.asList(c1, c2);
        article.setCommentaires(commentaires);


        articleService.saveArticle(article);


        Article article2 = new Article();
        article2.setAuteur("Damien GOUYETTE");
        article2.setTitre("Ceci est un autre titre");
        article2.setContenu("Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Praesent a lectus ipsum, vitae molestie orci. Morbi nisi neque, aliquam ac tristique et, ornare scelerisque mi. Nam sed libero sit amet tellus pretium iaculis ut quis ligula. Aenean eu eleifend lorem. Morbi velit magna, placerat ac scelerisque sit amet, egestas vitae justo. Sed eget ante vel nisl posuere ultricies ac ut libero. Nunc nec purus sit amet sapien laoreet molestie. Curabitur a diam orci, quis rutrum velit. Cras scelerisque fermentum magna et facilisis. ");
        article2.setDateCreation(new Date());

        articleService.saveArticle(article2);

    }
}


