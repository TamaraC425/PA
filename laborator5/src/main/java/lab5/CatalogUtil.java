package lab5;

import java.awt.*;
import java.io.*;
import java.net.URI;

public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException{
        try(var objectOutput=new ObjectOutputStream(new FileOutputStream(catalog.getPath()))){
            objectOutput.writeObject(catalog);
        }
    }
    public static Catalog load(String path) throws InvalidCatalogException,IOException{
        Catalog catalog=new Catalog();
        try{
            FileInputStream file=new FileInputStream(path);
            ObjectInputStream ois=new ObjectInputStream(file);
            catalog=(Catalog)ois.readObject();
        }
        catch (ClassNotFoundException e)
        {
            throw new InvalidCatalogException(e);
        }
        return  catalog;
    }
    public static  void view(Document doc)
    {
        try {
            if(!Desktop.isDesktopSupported())
            {
                System.out.println("Desktop is not supported on the current platform !");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            URI uri=new URI(doc.getLocation());
            desktop.browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}