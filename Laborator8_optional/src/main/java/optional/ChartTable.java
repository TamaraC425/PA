package optional;

import app.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ChartTable {
    public void createChartsTables()
    { try {
        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("create table billboard_album_chart(\n" + "nr int not null,\n" +
                "albumId int not null,\n" +
                "albumName varchar2(100) not null,\n" +
                "artistId int not null,\n" +"release_year int not null,"+
                "primary key(nr),\n" +
                "constraint fk_artistId FOREIGN KEY(artistId) REFERENCES artists(id),\n" +
                "constraint fk_albumId FOREIGN KEY(albumId) REFERENCES albums(id)\n" +
                ")");
        Statement statement1 = connection.createStatement();
        statement1.execute("create table top_albums_sales_chart(nr int not null,album_id int not null,album_name varchar2(100) not null,id_artist int not null,release_year int not null,primary key(nr),constraint fk_id_artist FOREIGN KEY(id_artist) REFERENCES artists(id),constraint fk_album_id FOREIGN KEY(album_id) REFERENCES albums(id))");
        Statement stm = connection.createStatement();
        stm.execute("create sequence album_chart_billboard minvalue 1 start with 1 increment by 1");
        stm.execute("create sequence album_chart_sales minvalue 1 start with 1 increment by 1");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
}
