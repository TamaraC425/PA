package com;

import java.text.DateFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.Locale;

public class Info {

    public Info(Locale locale) {
        Currency currency = Currency.getInstance(locale);
        DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
        System.out.println("Country : " + locale.getCountry());
        System.out.println("Language : " +locale.getLanguage());
        System.out.println("Currency : " + currency.getCurrencyCode());
        System.out.print("Week Days:");
        for (String s : dateFormatSymbols.getWeekdays()) {
            System.out.print(s + ",");
        }
        System.out.println();
        System.out.print("Months:");
        for (String s : dateFormatSymbols.getMonths()) {
            System.out.print(s + ",");
        }
        System.out.println();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.forLanguageTag(locale.getLanguage()));
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Today : " + dtf.format(now));
   }
}