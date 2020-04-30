package entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name="albums")
@NamedQueries({
        @NamedQuery(name="findAlbumByName", query ="select a from Album a where a.name=:name"),
        @NamedQuery(name="findByArtist", query ="select a from Album a where a.artistId=:artistId"),
        @NamedQuery(name="getAlbums", query = "Select a from Album a"),
})

public class Album {
    @Id
    @SequenceGenerator(name = "sequence",allocationSize=1,
            sequenceName = "album_id_auto")
    @GeneratedValue(generator = "sequence")
    @Column(name = "id")
    private int id;

    @Column(name="name")
    private String name;
    @Column(name="artist_id")
    private int artistId;
    @Column(name="release_year")
    private int releaseYear;
    @Column(name="genre")
     private String genre;
    public Album() {
    }

    public Album(String name, int artistId, int releaseYear,String genre) {
        this.name = name;
        this.artistId = artistId;
        this.releaseYear = releaseYear;
        this.genre=genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artistId=" + artistId +
                ", releaseYear=" + releaseYear +
                ", genre='" + genre + '\'' +
                '}';
    }
}

