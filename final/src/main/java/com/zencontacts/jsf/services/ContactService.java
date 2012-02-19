package com.zencontacts.jsf.services;


import com.zencontacts.jsf.domain.Contact;

import java.util.List;

public interface ContactService {

    /**
     * @return liste de contact
     */
    List<Contact> findAll();

    /**
     * cree un contact
     *
     * @param contact
     */
    void create(Contact contact);


    /**
     * Persiste une liste de contact
     *
     * @param contacts
     */
    void create(List<Contact> contacts);

    /**
     * Supprime un contact
     *
     * @param contact
     */
    void remove(Contact contact);
}
