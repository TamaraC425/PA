package repo;

import app.Database;
import entity.Album;
import entity.Artist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistRepositoryJDBC implements AbstractRepository<Artist> {
    public void create(Artist artist) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into artists(id,name,country) values(artist_auto_inc.nextval,?,?)");
            preparedStatement.setString(1, artist.getName());
            preparedStatement.setString(2, artist.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Artist findById(int id) {
        Artist artist = new Artist();
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from artists a where a.id=id");
            if (rs.next()) {
                artist.setId(rs.getInt(1));
                artist.setName(rs.getString(2));
                artist.setCountry(rs.getString(3));
                return artist;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artist;
    }

    public List<Artist> findByName(String name) {
        List<Artist> artistList = new ArrayList<>();
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select id from artists where name like '" + name + "'");
            while(rs.next()) {
                Artist artist=new Artist();
                artist.setId(rs.getInt(1));
                artistList.add(artist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artistList;
    }

    public List<Artist> rankingArtists() throws SQLException {
        List<Artist> artistList = new ArrayList<>();
        Connection connection = Database.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select id_artist from billboard_album_chart order by position_in_ranking");
            while (rs.next()) {
                Artist artist = new Artist();
                int id = rs.getInt(1);
                artist.setId(id);
                PreparedStatement preparedStatement = connection.prepareStatement("select name,country from artists where id=?");
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    artist.setName(resultSet.getString(1));
                    artist.setCountry(resultSet.getString(2));
                    artistList.add(artist);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artistList;
    }
    public List<Artist> getAll()
    {
        List<Artist> list = new ArrayList<>();
        try {
            Connection connection = Database.getConnection();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from artists");
            while (rs.next()) {
                Artist artist=new Artist();
                artist.setId(rs.getInt(1));
                artist.setName(rs.getString(2));
                artist.setCountry(rs.getString(3));
                list.add(artist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
