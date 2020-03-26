package lab5;

import java.io.IOException;

public interface Command {
    void DoCommand(String input) throws IOException, InvalidCatalogException, CustomException;
}
