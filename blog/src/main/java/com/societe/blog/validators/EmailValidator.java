package com.societe.blog.validators;

import org.apache.myfaces.shared.util.MessageUtils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@FacesValidator("com.societe.validators.EmailValidator")
public class EmailValidator implements Validator {


    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String enteredEmail = (String) value;

        Matcher matcher = pattern.matcher(enteredEmail);


        if (!matcher.matches()) {


            //MessageUtils.addMessage(FacesMessage.SEVERITY_ERROR, "mail invalide", null, component.getClientId());
            FacesMessage message = new FacesMessage();
            message.setDetail("INVALID_MAIL");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            //System.out.println("EMAIL  INVALIDE");
            throw new ValidatorException(message);
        }
    }
}
