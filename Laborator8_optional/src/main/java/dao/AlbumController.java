package dao;

import app.Database;
import optional.Album;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumController {
    public void create(String name,int artistId,int releaseYear) throws SQLException {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into albums(id,name,artist_id,release_year) values(album_id_auto.nextval,?,?,?)");
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
    public List<Album> findByYear(int releaseYear)
    {
        List<Album> list=new ArrayList<>();
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from albums where release_year=?");
            preparedStatement.setInt(1,releaseYear);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                Album album=new Album();
                album.setId(rs.getInt(1));
                album.setName(rs.getString(2));
                album.setArtistId(rs.getInt(3));
                album.setReleaseYear(rs.getInt(4));
                list.add(album);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

