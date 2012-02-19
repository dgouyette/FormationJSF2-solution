package com.societe.blog.domain;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Commentaire implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    @NotEmpty
    private String auteur;

    @NotEmpty
    private String contenu;

    @Email
    @NotEmpty
    private String email;

    @OneToOne
    private Article article;

    public Commentaire() {
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public Commentaire(String auteur, String contenu) {
        this.auteur = auteur;
        this.contenu = contenu;
    }



    /** GETTER AND SETTER **/


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
