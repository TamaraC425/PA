package entity;

import javax.persistence.*;

@Entity
@Table(name="billboard_album_chart")
@NamedQueries({
@NamedQuery(name="listBestAlbums",query="select c from Chart c order by nr_votes desc"),
        @NamedQuery(name="getAll", query = "Select c from Chart c"),
        })
public class Chart {
    @Id
    @SequenceGenerator(name = "sequence",allocationSize=1,
            sequenceName = "album_chart_billboard")
    @GeneratedValue(generator = "sequence")
    @Column(name="id")
    private int id;
    @Column(name="albumId")
    private int albumId;
    @Column(name="albumName")
    private  String albumName;
    @Column(name="artistId")
    private int artistId;
    @Column(name="release_year")
    private int releaseYear;
    @Column(name="nr_votes")
    private int nrVotes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
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

    public int getNrVotes() {
        return nrVotes;
    }

    public void setNrVotes(int nrVotes) {
        this.nrVotes = nrVotes;
    }

    @Override
    public String toString() {
        return "Chart{" +
                "id=" + id +
                ", albumId=" + albumId +
                ", albumName='" + albumName + '\'' +
                ", artistId=" + artistId +
                ", releaseYear=" + releaseYear +
                ", nrVotes=" + nrVotes +
                '}';
    }
}
