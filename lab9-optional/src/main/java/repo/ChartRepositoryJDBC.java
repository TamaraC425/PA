package repo;

import app.Database;
import entity.Album;
import entity.Artist;
import entity.Chart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChartRepositoryJDBC implements AbstractRepository<Chart> {
    @Override
    public void create(Chart chart) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into billboard_album_chart(id,albumId,albumName,artistId,release_year,nr_votes) values(album_chart_billboard.nextval,?,?,?,?,?)");
            preparedStatement.setInt(1, chart.getAlbumId());
            preparedStatement.setString(2, chart.getAlbumName());
            preparedStatement.setInt(3, chart.getArtistId());
            preparedStatement.setInt(4, chart.getReleaseYear());
            preparedStatement.setInt(5, chart.getNrVotes());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Chart findById(int id) {
        Chart chart = new Chart();
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from billboard_album_chart a where a.id=id");
            if (rs.next()) {
                chart.setId(rs.getInt(1));
                chart.setAlbumId(rs.getInt(2));
                chart.setAlbumName(rs.getString(3));
                chart.setArtistId(rs.getInt(4));
                chart.setReleaseYear(rs.getInt(5));
                chart.setNrVotes(rs.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chart;
    }

    @Override
    public List<Chart> findByName(String name) {
        return null;
    }

    public List<Chart> listBestAlbums(int limit) throws SQLException {
        Connection connection = Database.getConnection();
        List<Chart> list = new ArrayList<>();
        int k = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from billboard_album_chart order by nr_votes desc");
            while (rs.next() && k <= limit) {
                Chart chart = new Chart();
                chart.setId(rs.getInt(1));
                chart.setAlbumId(rs.getInt(2));
                chart.setAlbumName(rs.getString(3));
                chart.setArtistId(rs.getInt(4));
                chart.setReleaseYear(rs.getInt(5));
                chart.setNrVotes(rs.getInt(6));
                list.add(chart);
                k++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Chart> getAll()
    {
        List<Chart> list = new ArrayList<>();
        try {
            Connection connection = Database.getConnection();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from billboard_album_chart");
            while (rs.next()) {
                Chart chart = new Chart();
                chart.setId(rs.getInt(1));
                chart.setAlbumId(rs.getInt(2));
                chart.setAlbumName(rs.getString(3));
                chart.setArtistId(rs.getInt(4));
                chart.setReleaseYear(rs.getInt(5));
                chart.setNrVotes(rs.getInt(6));
                list.add(chart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
