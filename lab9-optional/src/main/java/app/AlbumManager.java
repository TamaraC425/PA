package app;

import entity.Album;
import entity.Artist;
import entity.Chart;
import repo.*;

import java.util.ArrayList;
import java.util.List;

public class AlbumManager {
    public static void main(String[] args) {
        Artist artist1 = new Artist();
        Album album = new Album();
        artist1.setName("Mac Miller");
        artist1.setCountry("Pennsylvania");
        Artist artist2 = new Artist();
        artist2.setName("BTS");
        artist2.setCountry("South Korea");
        ArtistRepositoryJPA artistRepository = new ArtistRepositoryJPA();
        artistRepository.create(artist1);
        artistRepository.create(artist2);
        System.out.println();
        album.setName("Circles");
        Artist artistTemp=new Artist();
        AlbumRepositoryJPA albumRepository = new AlbumRepositoryJPA();
        List<Artist> list=artistRepository.findByName(artist1.getName());
        if(list.isEmpty()==false) {
            artistTemp = list.get(0);
            album.setArtistId(artistTemp.getId());
            album.setReleaseYear(2018);
            album.setGenre("pop");
        albumRepository.create(album);
        }
        Album album2= new Album();
        album2.setName("MAP OF THE SOUL - 7");
        Artist artistTemp2=new Artist();
        List<Artist> artistList;
        artistList=artistRepository.findByName(artist2.getName());
        if(artistList.isEmpty()==false) {
            artistTemp2 = artistList.get(0);
            album2.setArtistId(artistTemp2.getId());
            album2.setReleaseYear(2020);
            album2.setGenre("kpop");
            albumRepository.create(album2);
        }
        ChartRepositoryJPA chartRepository=new ChartRepositoryJPA();
        Chart chart=new Chart();
        chart.setAlbumId(album.getArtistId());
        chart.setAlbumName(album.getName());
        chart.setArtistId(album.getArtistId());
        chart.setReleaseYear(album.getReleaseYear());
        chart.setNrVotes(400);
        chartRepository.create(chart);
        AbstractFactory abstractFactory=new AbstractFactory();
        Artist artist4 = new Artist();
        Album album4 = new Album();
        artist4.setName("Dua Lipa");
        artist4.setCountry("England");
        Artist artist5 = new Artist();
        artist5.setName("Ariana Grande");
        artist5.setCountry("Florida");
        AbstractRepository artistRepository4=abstractFactory.createArtist("JDBC");
        artistRepository4.create(artist4);
        artistRepository4.create(artist5);
        album4.setName("Future Nostalgia");
        Artist artist3 = new Artist();
        artist3=(Artist) artistRepository4.findByName(artist4.getName()).get(0);
        album4.setArtistId(artist3.getId());
        album4.setReleaseYear(2020);
        album4.setGenre("electronic");
        AbstractRepository albumRepository5 =abstractFactory.createAlbum("JDBC");
        albumRepository5.create(album4);
        Chart chart2=new Chart();
        chart2.setAlbumId(album4.getArtistId());
        chart2.setAlbumName(album4.getName());
        chart2.setArtistId(album4.getArtistId());
        chart2.setReleaseYear(album4.getReleaseYear());
        chart2.setNrVotes(400);
        chartRepository.create(chart2);
        Album album22= new Album();
        album22.setName("Thank U,Next");
        Artist artistAux=new Artist();
        artistAux=(Artist) artistRepository4.findByName(artist5.getName()).get(0);
        album22.setArtistId(artistAux.getId());
        album22.setReleaseYear(2019);
        album22.setGenre("dance-pop");
        albumRepository5.create(album22);

        //pentru partea de bonus
        for(int i=0;i<20;i++) {
            GenerateData data = new GenerateData();
            Artist artist=new Artist();
            artist=data.newArtist();
            ArtistRepositoryJPA artistRepositoryJPA=new ArtistRepositoryJPA();
            artistRepositoryJPA.create(artist);
           List<Artist> listOfArtists=new ArrayList<>();
            listOfArtists=artistRepositoryJPA.findByName(artist.getName());
            for(Artist a:listOfArtists) {
                int artistId=a.getId();
                Album fakeAlbum=new Album();
                fakeAlbum = data.newAlbum(artistId);
                AlbumRepositoryJPA albumRepositoryJPA = new AlbumRepositoryJPA();
                albumRepositoryJPA.create(fakeAlbum);
                Chart chartFake=new Chart();
                chartFake.setAlbumId(fakeAlbum.getArtistId());
                chartFake.setAlbumName(fakeAlbum.getName());
                chartFake.setArtistId(fakeAlbum.getArtistId());
                chartFake.setReleaseYear(fakeAlbum.getReleaseYear());
                int nrVotes = (int) (Math.random() * 500 + 100);
                chartFake.setNrVotes(nrVotes);
                chartRepository.create(chartFake);
            }
        }
        artistRepository.getAll().stream().forEach(System.out::println);
        ChartRepositoryJPA chartRepository2=new ChartRepositoryJPA();
        chartRepository2.getAll().stream().forEach(System.out::println);
    }
}
