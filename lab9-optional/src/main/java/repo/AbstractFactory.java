package repo;

public class AbstractFactory {

    public AbstractFactory() {
    }

    public AbstractRepository createAlbum(String use)
    {
        if (use == "JDBC") {
            return new AlbumRepositoryJDBC();
        }
        else {
            return new AlbumRepositoryJPA();
        }
    }
    public AbstractRepository createArtist(String use)
    {
        if (use == "JDBC") {
            return new ArtistRepositoryJDBC();
        }
        else {
            return new ArtistRepositoryJPA();
        }
    }
    public AbstractRepository createChart(String use)
    {
        if (use == "JDBC") {
            return new ChartRepositoryJDBC();
        }
        else {
            return new ChartRepositoryJPA();
        }
    }
}

