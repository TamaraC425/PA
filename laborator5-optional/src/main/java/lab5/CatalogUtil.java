package lab5;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException{
        try{
            FileWriter fw=new FileWriter((catalog.getPath()));
            fw.write(catalog.getName());
            fw.write(System.getProperty("line.separator"));
            fw.write(catalog.getPath());
            fw.write(System.getProperty("line.separator"));
            for(Document d:catalog.getDocuments())
            {  fw.write(d.getId());
                 fw.write(System.getProperty("line.separator"));
             fw.write(d.getName());
                fw.write(System.getProperty("line.separator"));
                fw.write(d.getLocation());
                fw.write(System.getProperty("line.separator"));
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*Implement the save and load methods using a plain text representation of the catalog */
    public static Catalog load(String path) throws InvalidCatalogException,IOException{
        Catalog catalog=new Catalog();
        List<Document> documents=new ArrayList<>();
        try{
            StringBuilder stringbuilder=new StringBuilder();
            BufferedReader br=new BufferedReader(new FileReader(path));
            String line;
            line=br.readLine();
            catalog.setName(line);
            line=br.readLine();
            catalog.setPath(line);
           while((line=br.readLine())!=null) {
               Document document=new Document();
               document.setId((line));
               document.setName(br.readLine());
               document.setLocation(br.readLine());
               documents.add(document);
           }
            catalog.setDocuments(documents);
        } catch (IOException e) {
            e.printStackTrace();
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
    public static void list(String path) throws IOException {
        Catalog catalog = new Catalog();
        List<Document> documents = new ArrayList<>();
        try {
            StringBuilder stringbuilder = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            line = br.readLine();
            catalog.setName(line);
            line = br.readLine();
            catalog.setPath(line);
            while ((line = br.readLine()) != null) {
                Document document = new Document();
                document.setId((line));
                document.setName(br.readLine());
                document.setLocation(br.readLine());
                documents.add(document);
            }
            catalog.setDocuments(documents);
            System.out.println(catalog.getName() + " : ");
            for (Document doc : catalog.getDocuments())
                System.out.println(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}