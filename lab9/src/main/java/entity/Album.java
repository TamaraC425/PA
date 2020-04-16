package entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name="albums")
@NamedQueries({
        @NamedQuery(name="findByName", query ="select id from artists where name like :name"),
        @NamedQuery(name="findByArtist", query ="select name from albums where artist_id=:artistId"),
})

public class Album {
    @Id
    @SequenceGenerator(name = "sequence",
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

    public Album() {
    }

    public Album(String name, int artistId, int releaseYear) {
        this.name = name;
        this.artistId = artistId;
        this.releaseYear = releaseYear;
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

    @Override
    public String toString() {
        return "Album{" +
                ", name='" + name + '\'' +
                ", artistId=" + artistId +
                ", releaseYear=" + releaseYear +
                '}';
    }
}

