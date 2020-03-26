package lab5;

import java.io.IOException;
import java.util.StringTokenizer;

public class ViewCommand implements Command {
    String input;

    public ViewCommand(String input) throws IOException, InvalidCatalogException, CustomException {
        this.input = input;
        DoCommand(input);
    }

    @Override
    public void DoCommand(String input) throws CustomException {
        Document document=new Document();
        StringTokenizer stringTokenizer = new StringTokenizer(input, " ");
        if(stringTokenizer.countTokens()<4) throw  new CustomException("Nu ati introdus argumente !! ");
        String command = stringTokenizer.nextToken();
        while(command.equals(" "))
            command = stringTokenizer.nextToken();
        String name = stringTokenizer.nextToken();
        while(name.equals(" "))
            name = stringTokenizer.nextToken();
        String id = stringTokenizer.nextToken();
        while(id.equals(" ")) {
            id = stringTokenizer.nextToken();
        }
        String location = stringTokenizer.nextToken();
        while(location.equals(" ")) {
            location= stringTokenizer.nextToken();
        }
       document.setName(name);
        document.setId(id);
        document.setLocation(location);
        CatalogUtil.view(document);
    }
}
