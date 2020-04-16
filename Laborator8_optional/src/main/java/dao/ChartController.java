package dao;

import app.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChartController {
    public void createBillboardChart(String albumName,int albumId,int artistId,int releaseYear) throws SQLException {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into billboard_album_chart(nr,albumId,albumName,artistId,release_year) values(album_chart_billboard.nextval,?,?,?,?)");
            preparedStatement.setInt(1, albumId);
            preparedStatement.setString(2, albumName);
            preparedStatement.setInt(3, artistId);
            preparedStatement.setInt(4, releaseYear);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public void createTopSalesChart(String albumName,int albumId,int artistId) throws SQLException {
            Connection connection = Database.getConnection();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into top_albums_sales_chart(nr,album_id,album_name,id_artist,release_year) values(album_chart_billboard.nextval,?,?,?,?)");
                preparedStatement.setInt(1, albumId);
                preparedStatement.setString(2, albumName);
                preparedStatement.setInt(3, artistId);
                preparedStatement.setInt(4,2019);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
