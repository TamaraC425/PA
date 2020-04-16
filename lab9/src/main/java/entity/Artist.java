package entity;

import javax.persistence.*;

@Entity
@Table(name="artists")
@NamedQueries({
        @NamedQuery(name="findByName", query ="select id from artists where name like :name"),
})
public class Artist {
    @Id
    @SequenceGenerator(name = "sequence",
            sequenceName = "artist_auto_inc")
    @GeneratedValue(generator = "sequence")
    @Column(name = "id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="country")
    private String country;

    public Artist() {
    }

    public Artist(String name, String country) {
        this.name = name;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Artist{" +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
