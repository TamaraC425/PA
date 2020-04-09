package dao;


import app.Database;

import java.sql.*;

public class ArtistController {
    public void create(String name, String country) throws SQLException {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into artists(name,country) values(?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, country);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("select id from artists where name like '" + name + "'")){
            if(rs.next())
            {
                return rs.getInt(1);

            }
            else{
                return null;}
        }
    }
}

