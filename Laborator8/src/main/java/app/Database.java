package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class Database {
    private static  Connection connection=null;

    private Database() {
    }
    public static void createConnection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/musicalbums","dba","sql");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();}
    }
    public static Connection getConnection() throws SQLException {
        if(connection==null) {
            createConnection();
        }
        return connection;
    }
    public static void closeConnection() throws SQLException
    {
        connection.close();
    }
    public static void commit() throws SQLException {
        connection.commit();
    }
}