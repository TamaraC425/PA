package player;

import javax.persistence.*;

@Entity
@Table(name="game")
public class Game {
    @Id
    @SequenceGenerator(name = "sequence",allocationSize = 1,
            sequenceName = "game_auto_inc")
    @GeneratedValue(generator = "sequence")
    @Column(name="id")
    private int id;
    @Column(name="idPlayer1")
    private int idPlayer1;
    @Column(name="idPlayer2")
    private int idPlayer2;
    @Column(name="information")
    private String information;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPlayer1() {
        return idPlayer1;
    }

    public void setIdPlayer1(int idPlayer1) {
        this.idPlayer1 = idPlayer1;
    }

    public int getIdPlayer2() {
        return idPlayer2;
    }

    public void setIdPlayer2(int idPlayer2) {
        this.idPlayer2 = idPlayer2;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", idPlayer1=" + idPlayer1 +
                ", idPlayer2=" + idPlayer2 +
                ", information='" + information + '\'' +
                '}';
    }
}
