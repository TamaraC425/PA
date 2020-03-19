package lab5;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Main application=new Main();
        try {
            application.testCreateSave();
            application.testLoadView();
        } catch (IOException | InvalidCatalogException e) {
            e.printStackTrace();
        }
    }
    private void testCreateSave() throws IOException {
        Catalog catalog=new Catalog("Java Resources","C:\\Users\\Asus\\Desktop\\laborator5\\catalog.ser");
        Document doc=new Document("java1","Java course 1","https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type","Slides");
        catalog.add(doc);
        CatalogUtil.save(catalog);
    }
    private void testLoadView() throws InvalidCatalogException,IOException {
        Catalog catalog = CatalogUtil.load("C:\\Users\\Asus\\Desktop\\laborator5\\catalog.ser");
        Document doc = catalog.findById("java1");
        CatalogUtil.view(doc);
    }
}
