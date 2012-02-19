package com.zencontacts.jsf.services;


import com.zencontacts.jsf.domain.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class DefaultContactService implements ContactService {


    private final static Logger LOGGER = LoggerFactory.getLogger(DefaultContactService.class);

    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public List<Contact> findAll() {
    	
        List<Contact> contacts = em.createQuery("select c from Contact c").getResultList();
        LOGGER.debug("{} contact(s) trouve(s)", contacts.size());
        return contacts;
    }


    public void remove(Contact contact) {
        LOGGER.debug("Suppression du contact {}", contact);
        em.remove(em.merge(contact));
    }


    public void create(final Contact contact) {
        LOGGER.debug("Creation du contact {}", contact);
        em.persist(contact);
    }


    public void create(List<Contact> contacts) {
        for (Contact contact : contacts) {
            em.persist(contact);
        }
    }
}
