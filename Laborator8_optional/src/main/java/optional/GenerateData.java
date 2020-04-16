package optional;

import com.github.javafaker.Faker;

public class GenerateData {
    public Artist newArtist() {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String country = faker.country().name();
        Artist artist = new Artist(name, country);
        return artist;
    }

    public Album newAlbum(int artistId) {
        Faker faker = new Faker();
        String albumName = null;
        int temp = (int) (Math.random() * 4 + 1);
        if (temp == 1) {
            albumName = faker.name().firstName();
        }
        if (temp == 2) {
            albumName = faker.color().name();
        }
        if (temp == 3) {
            albumName = faker.superhero().name();
        }
        if (temp == 4) {
            albumName = faker.book().title();
        }
        int releaseYear = faker.number().numberBetween(2018,2020);
        Album album = new Album(albumName, artistId, releaseYear);
        return album;
    }
}
