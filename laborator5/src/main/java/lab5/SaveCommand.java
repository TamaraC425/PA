package lab5;

import java.io.IOException;
import java.util.StringTokenizer;

public class SaveCommand implements Command{
    String input;

    public SaveCommand(String input) throws IOException, CustomException {

        DoCommand(input);
    }

    @Override
    public void DoCommand(String input){
        try {
            Catalog catalog = new Catalog();
            StringTokenizer stringTokenizer = new StringTokenizer(input, " ");
            if (stringTokenizer.countTokens() < 3) throw new CustomException("Trebuie introduse trei  argumente !! ");
            String command = stringTokenizer.nextToken();
            while (command.equals(" "))
                command = stringTokenizer.nextToken();
            String name = stringTokenizer.nextToken();
            while (name.equals(" "))
                name = stringTokenizer.nextToken();
            String path = stringTokenizer.nextToken();
            while (path.equals(" ")) {
                path = stringTokenizer.nextToken();
            }
            catalog.setName(name);
            catalog.setPath(path);
            CatalogUtil.save(catalog);
        } catch (CustomException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
