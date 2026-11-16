package org.example.oopweek9gui1.database;

import java.sql.*;

public class DBConnection {
    private Connection conn;
    private boolean connected = false;
    private final String url;
    private final String username;
    private final String password;

    public DBConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void connect() throws SQLException {
        if (!connected) {
            conn = DriverManager.getConnection(url,  username, password);
            connected = true;
        }
    }

    public void disconnect() throws SQLException {
        if (connected) {
            conn.close();
            connected = false;
        }
    }

    public int sqlUpdate(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        int updatedRows = stmt.executeUpdate(sql);
        return updatedRows;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }

    public String formatResult(ResultSet rs) throws SQLException {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
            sb.append(rs.getMetaData().getColumnName(i) + "\t");
        }
        sb.append("\n");

        while (rs.next()) {
            for  (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                sb.append(rs.getString(i) + "\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public ResultSet prepQuery(String pStatement, String value) throws SQLException {
        PreparedStatement prepstmt = conn.prepareStatement(pStatement);
        prepstmt.setString(1, value);
        ResultSet rs = prepstmt.executeQuery();
        return rs;
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        PreparedStatement prepstmt = conn.prepareStatement(sql);
        return prepstmt;
    }

}
