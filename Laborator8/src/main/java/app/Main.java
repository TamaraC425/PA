package app;

import dao.AlbumController;
import dao.ArtistController;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        ArtistController artists=new ArtistController();
        AlbumController album=new AlbumController();
        artists.create("Dua Lipa","England");
        artists.create("Ariana Grande","Florida");
        Database.commit();
        album.create("Future Nostalgia",artists.findByName("Dua Lipa"),2020);
        album.create("Thank U,Next",artists.findByName("Ariana Grande"),2019);
        Database.commit();
        Database.closeConnection();
    }
}

