package repo;

import app.Database;
import entity.Album;
import entity.Artist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepositoryJDBC implements AbstractRepository<Album> {
    @Override
    public void create(Album album) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into albums(id,name,artist_id,release_year,genre) values(album_id_auto.nextval,?,?,?,?)");
            preparedStatement.setString(1, album.getName());
            preparedStatement.setInt(2, album.getArtistId());
            preparedStatement.setInt(3, album.getReleaseYear());
            preparedStatement.setString(4,album.getGenre());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Album findById(int id) {
        Album album = new Album();
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from albums a where a.id=id");
            if (rs.next()) {
                album.setId(rs.getInt(1));
                album.setName(rs.getString(2));
                album.setArtistId(rs.getInt(3));
                album.setReleaseYear(rs.getInt(4));
                album.setGenre(rs.getString(5));
                return album;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return album;
    }
     @Override
    public List<Album> findByName(String name) {
        List<Album> albumList = new ArrayList<>();
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select id from albums where name like '" + name + "'");
            while(rs.next()) {
                Album album=new Album();
                album.setId(rs.getInt(1));
                albumList.add(album);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albumList;
    }

    public List<Album> findByArtist(int artistId) throws SQLException {
        Connection connection = Database.getConnection();
        List<Album> albumList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select name from albums where artist_id=?");
            preparedStatement.setInt(1, artistId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Album album = new Album();
                album.setName(rs.getString("name"));
                albumList.add(album);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albumList;
    }

    public List<Album> findByYear(int releaseYear) {
        List<Album> list = new ArrayList<>();
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from albums where release_year=?");
            preparedStatement.setInt(1, releaseYear);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Album album = new Album();
                album.setId(rs.getInt(1));
                album.setName(rs.getString(2));
                album.setArtistId(rs.getInt(3));
                album.setReleaseYear(rs.getInt(4));
                album.setGenre(rs.getString(5));
                list.add(album);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Album> getAll()
    {
        List<Album> list = new ArrayList<>();
        try {
            Connection connection = Database.getConnection();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from albums");
            while (rs.next()) {
                Album album = new Album();
                album.setId(rs.getInt(1));
                album.setName(rs.getString(2));
                album.setArtistId(rs.getInt(3));
                album.setReleaseYear(rs.getInt(4));
                album.setGenre(rs.getString(5));
                list.add(album);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
