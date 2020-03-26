package lab5;

import java.io.IOException;
import java.util.StringTokenizer;

public class LoadCommand implements Command{
    String input;

    public LoadCommand(String input) throws IOException, InvalidCatalogException {
        this.input = input;
        DoCommand(input);
    }

    @Override
    public void DoCommand(String input) throws IOException, InvalidCatalogException {
        StringTokenizer stringTokenizer = new StringTokenizer(input, " ");
        String command = stringTokenizer.nextToken();
        while(command.equals(" ")) {
            command = stringTokenizer.nextToken();
        }
        String path = stringTokenizer.nextToken();
        while(path.equals(" ")) {
            path = stringTokenizer.nextToken();
        }
        Catalog catalog=CatalogUtil.load(path);
        System.out.println(catalog);
    }
}
