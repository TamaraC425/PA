package dao;

import app.Database;

import java.sql.*;

public class AlbumController {
    public void create(String name,int artistId,int releaseYear) throws SQLException {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into albums(name,artist_id,release_year) values(?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, artistId);
            preparedStatement.setInt(3,releaseYear);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String findByArtist(int artistId) throws SQLException {
        Connection connection = Database.getConnection();
        String nume="";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select name from albums where artist_id=?");
            preparedStatement.setInt(1,artistId);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                nume=rs.getString("name");
                return nume;
            }
            else{
                return null;}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nume;
    }
}

