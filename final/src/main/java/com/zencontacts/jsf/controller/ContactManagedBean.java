package com.zencontacts.jsf.controller;


import com.zencontacts.jsf.domain.Contact;
import com.zencontacts.jsf.services.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Named
@RequestScoped
public class ContactManagedBean implements Serializable {

    
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LoggerFactory.getLogger(ContactManagedBean.class);

    private Contact currentContact;

    private Date currentDate = new Date();


    @Inject
    private ContactService contactService;

    /**
     * Data liés au tableau*
     */
    private DataModel<Contact> contacts;

    /**
     * Initialise les donnees pour l'écran
     */
    public ContactManagedBean() {
        currentContact = new Contact();
    }


    public enum FlashType {
        SUCCESS, ERROR;
    }

    public void flashMessage(final String message, FlashType flashType) {

        LOGGER.debug("message ={}, flashType={}", message, flashType);
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put(flashType.toString(), message);
    }

    @PostConstruct
    public void init() {
        reload();
    }

    public void reload() {
        LOGGER.debug("Rechargement");
        this.contacts = new ListDataModel<Contact>(contactService.findAll());

    }

    public String ajouter() {
        LOGGER.debug("Ajout d'un contact {}", currentContact);
        contactService.create(currentContact);
        reload();
        currentContact = new Contact();
        flashMessage("Contact ajouté", FlashType.SUCCESS);
        return "liste";
    }


    public String supprimer(final Contact contact) {
        LOGGER.debug("Suppression d'un contact {}", contact);
        contactService.remove(contact);
        reload();
        flashMessage("Contact supprimé", FlashType.SUCCESS);
        return "liste";
    }

    /**
     * GETTER AND SETTER *
     */
    public DataModel<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(DataModel<Contact> contacts) {
        this.contacts = contacts;
    }

    public Contact getCurrentContact() {
        return currentContact;
    }

    public void setCurrentContact(Contact currentContact) {
        this.currentContact = currentContact;
    }

    public ContactService getContactService() {
        return contactService;
    }

    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }


    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
}
