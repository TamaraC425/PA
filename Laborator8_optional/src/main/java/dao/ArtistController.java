package dao;

import app.Database;
import optional.Artist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistController {
    public void create(String name, String country) throws SQLException {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into artists(id,name,country) values(artist_auto_inc.nextval,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, country);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();
        List<Integer> list=new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("select id from artists where name like '" + name + "'");
            while(rs.next())
            {
                list.add(rs.getInt(1));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Artist> rankingArtists() throws SQLException {
        List<Artist> artistList = new ArrayList<>();
        Connection connection = Database.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select id_artist from top_albums_sales_chart order by nr");
          while(rs.next()) {
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
}


