package com;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale {
    private final String name = "res.Messages";
    private Locale locale;
    private ResourceBundle resourceBundle;
    public  SetLocale(String language)
    {
       this.locale = Locale.forLanguageTag(language);
       this.resourceBundle = ResourceBundle.getBundle(name, locale);
    }

    public Locale getLocale() {
        return locale;
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }
}
