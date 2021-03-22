package com.ams.ms.generic.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class CustomMessageSource {
    @Autowired
    private MessageSource messageSource;

    public String get(String code) {
        return messageSource.getMessage(code,null,getCurrentLocale());
    }

    public String get(String code,String param) {
        return messageSource.getMessage(code, new String[]{param},getCurrentLocale());
    }

    public String get(String code,Object... objects) {
        return messageSource.getMessage(code,objects,getCurrentLocale());
    }

    private Locale getCurrentLocale() {
        Locale locale = LocaleContextHolder.getLocale();
        if(locale.getDisplayLanguage().equalsIgnoreCase("np")) {
            locale = new Locale("np", "Nepal");
        }
        return locale;
    }

}
