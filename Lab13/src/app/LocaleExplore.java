package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LocaleExplore {
    private final String name = "res.Messages";
    private Locale locale;
    private ResourceBundle resourceBundle;
    Properties commands = new Properties();

    public void run() {
        /*Locale.setDefault(Locale.Category.DISPLAY, Locale.forLanguageTag("ro-RO"));
        Locale.setDefault(Locale.Category.FORMAT, Locale.forLanguageTag("ro-RO"));
        Locale.setDefault(Locale.Category.DISPLAY, Locale.US);
        Locale.setDefault(Locale.Category.FORMAT, Locale.US);*/
        Scanner scanner = new Scanner(System.in);
        setLocale("en-US");
        while (true) {
            System.out.println(message("prompt"));
            String command = scanner.nextLine();
            if (command.equals("exit")) break;
            String[] input = command.trim().split("\\s+");
            switch (input[0]) {
                case "set":
                    setLocale(input[1]);
                    break;
                case "info":
                    localeInfo();
                    break;
                case "locales":
                    showLocales();
                    break;
                default:
                    System.out.println(message("invalid"));
            }

        }

    }

    private String message(String key, String... arguments) {
        String pattern = resourceBundle.getString(key);
        String message = new MessageFormat(pattern).format(arguments);
        return message;
    }

    private void setLocale(String language) {
        SetLocale locale=new SetLocale(language);
        this.locale=locale.getLocale();
        this.resourceBundle=locale.getResourceBundle();
        message("locale.set", language);
    }
    private void localeInfo() {
        message("info");
        new Info(this.locale);
    }

    private void showLocales() {
        message("locales");
        new DisplayLocales();
    }

    public void runOptional() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        InputStream inputStream=getClass().getClassLoader().getResourceAsStream("Commands.properties") ;
        commands.load(inputStream);
        Scanner scanner = new Scanner(System.in);
        StringBuilder className;
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("exit")) break;
            String[] input = command.trim().split("\\s+");
            switch (input[0]) {
                case "set": {
                    className=new StringBuilder(commands.getProperty("set-locale.impl"));
                    className.delete(0,4);
                    Class mClass = Class.forName(className.toString());
                    mClass.getConstructor().newInstance(input[1]);
                    break;
                }
                case "info": {
                     className=new StringBuilder(commands.getProperty("info-locale.impl"));
                    className.delete(0,4);
                    Class mClass = Class.forName(className.toString());
                    mClass.getConstructor().newInstance(input[1]);
                    break;
                }
                case "locales": {
                    className=new StringBuilder(commands.getProperty("display-locale.impl"));
                    className.delete(0,4);
                    Class mClass = Class.forName(className.toString());
                    mClass.getConstructor().newInstance();
                    break;
                }
                default:
                    System.out.println("invalid");
            }

        }

    }

    public static void main(String args[]) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        new LocaleExplore().run();

    }
}