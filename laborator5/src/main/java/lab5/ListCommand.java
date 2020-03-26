package lab5;

import java.io.IOException;
import java.util.StringTokenizer;

public class ListCommand implements Command{
    String input;

    public ListCommand(String input) throws CustomException, IOException {
        this.input = input;
        DoCommand(input);
    }

    @Override
    public void DoCommand(String input) {
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(input, " ");
            if (stringTokenizer.countTokens() < 2) throw new CustomException("Trebuie introdus si un path !! ");
            String command = stringTokenizer.nextToken();
            while (command.equals(" "))
                command = stringTokenizer.nextToken();
            String path = stringTokenizer.nextToken();
            while (path.equals(" ")) {
                path = stringTokenizer.nextToken();
            }
            CatalogUtil.list(path);
        } catch (CustomException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
