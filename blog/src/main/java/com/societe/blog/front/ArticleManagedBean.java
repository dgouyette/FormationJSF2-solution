package com.societe.blog.front;

import com.societe.blog.domain.Article;
import com.societe.blog.domain.Commentaire;
import com.societe.blog.services.ArticleService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ArticleManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private long idArticle;

	private List<Article> articles;

	private Article currentArticle;

	private Commentaire currentCommentaire;

	@Inject
	private ArticleService articleService;

	@PostConstruct
	public void afterPropertiesSet() {
		System.out.println("AfterPropertiesSet");
		currentArticle = new Article();
		reload();
	}

	public String afficheArticle(Article article) {
		currentArticle = article;
		return "show";
	}

	private void reload() {
		articles = articleService.findAllArticle();
	}

	public void initParamsView() {
		currentArticle = articleService.findArticleById(idArticle);
		currentCommentaire = new Commentaire();
	}

	public String ajouterArticle() {
		articleService.saveArticle(currentArticle);
		articles = articleService.findAllArticle();
		return "index?faces-redirect=true";
	}

	public void ajouterCommentaire() throws InterruptedException {
		Thread.sleep(10000L);
		currentArticle.getCommentaires().add(currentCommentaire);
		articleService.updateArticle(currentArticle);
		reload();
	}

	/**
	 * GETTER / SETTER *
	 */

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article getCurrentArticle() {
		return currentArticle;
	}

	public void setCurrentArticle(Article currentArticle) {
		this.currentArticle = currentArticle;
	}

	public long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(long idArticle) {
		this.idArticle = idArticle;
	}

	public Commentaire getCurrentCommentaire() {
		return currentCommentaire;
	}

	public void setCurrentCommentaire(Commentaire currentCommentaire) {
		this.currentCommentaire = currentCommentaire;
	}
}
