package lab5;

import java.io.*;
import java.util.StringTokenizer;

public class ReportHtmlCommand implements Command{
    String input;
  Catalog catalog;
    public ReportHtmlCommand(Catalog catalog,String input) throws InvalidCatalogException, CustomException, IOException {
        this.input = input;
        this.catalog=catalog;
        DoCommand(input);
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void DoCommand(String input) {
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(input, " ");
            String command = stringTokenizer.nextToken();
            while (command.equals(" ")) {
                command = stringTokenizer.nextToken();
            }
            String name = stringTokenizer.nextToken();
            while (name.equals(" "))
                name = stringTokenizer.nextToken();
            if (name.equals("html")) {
               StringBuilder stringBuilder=new StringBuilder();
               stringBuilder.append("<html><head><title>Continut Catalog</title></head><body>Catalog<br>");
               stringBuilder.append(this.catalog.getName()+"<br>");
               for(Document doc:this.catalog.getDocuments()) {
                   stringBuilder.append("Document : ");
                   stringBuilder.append("Id   "+doc.getId() + "<br>");
                   stringBuilder.append("Name    "+doc.getName() + "<br>");
                   stringBuilder.append("Location    "+doc.getLocation() + "<br>");
                   stringBuilder.append("Tags"+doc.getTags() + "<br>");
               }
               stringBuilder.append("</body></html>");
               File file=new File("C:\\Users\\Asus\\Desktop\\laborator5\\catalog.html");
                BufferedWriter bw=new BufferedWriter((new FileWriter(file)));
                bw.write(stringBuilder.toString());
                bw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
