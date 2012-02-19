package com.zencontacts.jsf.autils;


import java.util.Arrays;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.zencontacts.jsf.domain.Contact;
import com.zencontacts.jsf.services.ContactService;


@Component

@ApplicationScoped
public class Bootstrap {

    private static final Logger LOGGER = LoggerFactory.getLogger(Bootstrap.class);


    @Inject
    private ContactService contactService;


    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        LOGGER.debug("*******************************************************************");
        LOGGER.debug("***                                                            ****");
        LOGGER.debug("***      Chargement des donnees de l'application zencontact    ****");
        LOGGER.debug("***                                                            ****");
        LOGGER.debug("*******************************************************************");


        Contact c1 = new Contact("George", "Washington", new Date(1932, 2, 22), "g.washington@gmail.com");
        Contact c2 = new Contact("John", "Adams", new Date(1935, 10, 30), "j.adams@gmail.com");
        Contact c3 = new Contact("Thomas", "Jefferson", new Date(1943, 4, 13), "t.jefferson@gmail.com");
        Contact c4 = new Contact("Madison", "James ", new Date(1951, 1, 1), "j.madison@gmail.com");
        Contact c5 = new Contact("Monroe", "James", new Date(1958, 1, 1), "j.monroe@gmail.com");
        Contact c6 = new Contact("John", "Quincy Adams", new Date(1967, 1, 1), "j.q.adams@gmail.com");
        Contact c7 = new Contact("Jackson", "Andrew", new Date(1967, 3, 15), "t.jefferson@gmail.com");
        Contact c8 = new Contact("Van Buren", "Martin", new Date(1982, 12, 5), "m.v.buren@gmail.com");
        Contact c9 = new Contact("William", "H. Harisson", new Date(1943, 4, 13), "w.h.harisson@gmail.com");
        Contact c10 = new Contact("John", "Tyler", new Date(1990, 1, 1), "j.tyler@gmail.com");

        contactService.create(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));
    }
}
