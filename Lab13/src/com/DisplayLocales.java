package com;

import java.util.Locale;

public class DisplayLocales {
  public DisplayLocales()
  {
      Locale availableLocales[] = Locale.getAvailableLocales();
      for (Locale locale : availableLocales) {
          System.out.println(locale.getDisplayCountry() + "\t" +locale.getDisplayLanguage());
      }
  }
}
