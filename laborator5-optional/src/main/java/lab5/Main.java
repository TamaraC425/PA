package lab5;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Main application=new Main();
        try {
          //  application.testCreateSave();
            //application.testLoadView();
            application.testShell();
        } catch (IOException | InvalidCatalogException | InvalidCommandException | CustomException e) {
            e.printStackTrace();
        }
    }
    private void testCreateSave() throws IOException {
        Catalog catalog=new Catalog("Java Resources","C:\\Users\\Asus\\Desktop\\laborator5\\catalog.txt");
        Document doc=new Document("java1","Java course 1","https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type","Slides");
        catalog.add(doc);
        CatalogUtil.save(catalog);
    }
    private void testLoadView() throws InvalidCatalogException,IOException {
        Catalog catalog = CatalogUtil.load("C:\\Users\\Asus\\Desktop\\laborator5\\catalog.txt");
        Document doc = catalog.findById("java1");
        CatalogUtil.view(doc);
    }
    private void testShell() throws IOException, InvalidCommandException, InvalidCatalogException, CustomException {
        Catalog catalog=new Catalog("Java Resources","C:\\Users\\Asus\\Desktop\\laborator5\\catalog.txt");
        Document doc=new Document("java1","Java course 1","https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type","Slides");
        catalog.add(doc);
        Shell shell=new Shell(catalog);
        shell.getCommand();
    }
}
