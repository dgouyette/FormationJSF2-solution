package com.societe.blog.converters;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


@FacesConverter("com.societe.converters.EmailConverter")
public class EmailConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
        return value.toString();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
        String prefixe = "mailto:";
        String email = value.toString();
        if (email.isEmpty()){
            return "";
        }

        if (!email.startsWith(prefixe)) {
            email = prefixe + email;
        }
        return email;
    }
}
