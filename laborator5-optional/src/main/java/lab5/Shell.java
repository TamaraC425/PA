package lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Shell {
   private  Catalog catalog;

    public Shell() {
    }

    public Shell(Catalog catalog) {
        this.catalog = catalog;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public void getCommand() throws IOException, InvalidCommandException, InvalidCatalogException, CustomException {
        InputStreamReader reader=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(reader);
        System.out.println("Introduceti numele comenzii si argumentele necesare!\n Pentru comanda load specificati path !\nPentru comanda view introduceti numele ,id-ul si locatia unui document !\nPentru comanda list specificati un path!\n Comanda : report html");
            String command;
              String input=bufferedReader.readLine();
              StringTokenizer tokenizer=new StringTokenizer(input," ");
              if(tokenizer.countTokens()<2) throw  new CustomException("Nu ati introdus argumente !! ");
              if(tokenizer.hasMoreTokens()) {
                  command = tokenizer.nextToken();
                  if (command.equals("load")) new LoadCommand(input);
                  else if (command.equals("list")) new ListCommand(input);
                  else if(command.equals("view")) new ViewCommand(input);
                   else if(command.equals("save")) new SaveCommand(input);
                   else if(command.equals("report")) new ReportHtmlCommand(getCatalog(),input);
                   else
                       throw new InvalidCommandException("Introduceti una din comenzile: load,list,view sau save !");
          }
    }
}
