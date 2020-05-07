package player;

import javax.persistence.*;

@Entity
@Table(name="players")
public class Player {
@Id
@SequenceGenerator(name = "sequence",allocationSize = 1,
        sequenceName = "player_auto_inc")
@GeneratedValue(generator = "sequence")
@Column(name="id")
    private int id;
@Column(name="name")
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}


