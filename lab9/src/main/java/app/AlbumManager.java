package app;

import entity.Album;
import entity.Artist;
import repo.AlbumRepository;
import repo.ArtistRepository;

public class AlbumManager {
    public static void main(String[] args) {
        Artist artist1 = new Artist();
        Album album = new Album();
        artist1.setName("Dua Lipa");
        artist1.setCountry("England");
        Artist artist2 = new Artist();
        artist2.setName("Ariana Grande");
        artist2.setCountry("Florida");
        ArtistRepository artistRepository = new ArtistRepository();
        artistRepository.create(artist1);
        artistRepository.create(artist2);
        album.setName("Future Nostalgia");
        Artist artisttemp=new Artist();
        artisttemp=artistRepository.findByName(artist1.getName());
        album.setArtistId(artisttemp.getId());
        album.setReleaseYear(2020);
        AlbumRepository albumRepository = new AlbumRepository();
        albumRepository.create(album);
        Album album2= new Album();
        album2.setName("Thank U,Next");
        Artist artisttemp2=new Artist();
        artisttemp2=artistRepository.findByName(artist2.getName());
        album2.setArtistId(artisttemp2.getId());
        album2.setReleaseYear(2019);
        albumRepository.create(album2);
    }
}
