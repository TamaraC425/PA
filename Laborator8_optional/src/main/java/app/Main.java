package app;

import dao.AlbumController;
import dao.ArtistController;
import dao.ChartController;
import optional.Album;
import optional.Artist;
import optional.Chart;
import optional.GenerateData;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
    /*    ArtistController artists=new ArtistController();
        AlbumController album=new AlbumController();
        artists.create("Dua Lipa","England");
        artists.create("Ariana Grande","Florida");
        Database.commit();
        album.create("Future Nostalgia",artists.findByName("Dua Lipa").ge,2020);
        album.create("Thank U,Next",artists.findByName("Ariana Grande"),2019);
        Database.commit();
        Database.closeConnection();
        */
    for(int i=0;i<10;i++) {
        GenerateData data = new GenerateData();
        Artist artist=new Artist();
        artist=data.newArtist();
        ArtistController artistController=new ArtistController();
        artistController.create(artist.getName(),artist.getCountry());
        List<Integer> listId=new ArrayList<>();
       listId=artistController.findByName(artist.getName());
       for(Integer id:listId) {
           int artistId=id;
           Album album=new Album();
           album = data.newAlbum(artistId);
           AlbumController albumController = new AlbumController();
           albumController.create(album.getName(), artistId, album.getReleaseYear());
       }
    }

    ChartController chartController=new ChartController();
    AlbumController albums=new AlbumController();
        Chart chart1=new Chart("BillboardTopAlbum");
    chart1.setAlbumList(albums.findByYear(2018));
    for(Album album:chart1.getAlbumList()) {
        chartController.createBillboardChart(album.getName(), album.getId(), album.getArtistId(), album.getReleaseYear());
    }
        System.out.println(chart1.toString());
        Chart chart2=new Chart("TopSalesAlbums");
        chart2.setAlbumList(albums.findByYear(2019));
        for(Album album:chart2.getAlbumList())
        {
            chartController.createTopSalesChart(album.getName(),album.getId(),album.getArtistId());
        }
        List<Artist> artistList=new ArrayList<>();
        ArtistController artistController=new ArtistController();
        artistList=artistController.rankingArtists();
        for(Artist artist:artistList)
        {
            System.out.println(artist.toString());
        }
    }
}

