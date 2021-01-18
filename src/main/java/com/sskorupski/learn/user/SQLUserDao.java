package com.sskorupski.learn.user;

import java.sql.*;
import java.util.ArrayList;

public class SQLUserDao implements UserDAO {

    @Override
    public ArrayList<User> getAll() throws SQLException {

        String DBurl = "jdbc:mysql://127.0.0.1:3306/jdbc";
        ArrayList<User> users = new ArrayList<>();
        Connection cxion = null;
        try {
            cxion = DriverManager.getConnection(DBurl, "root", "example");
            System.out.println("Cxion ok");
            cxion.setAutoCommit(false);
            Statement statement = cxion.createStatement();
            ResultSet userQueryResult = statement.executeQuery("SELECT  id, username, email, password FROM users");

            User user;
            while (userQueryResult.next()) {
                user = new User();
                user.setId(userQueryResult.getLong("id"));
                user.setUsername(userQueryResult.getString("username"));
                user.setEmail(userQueryResult.getString("email"));
                user.setPassword(userQueryResult.getString("password"));
                users.add(user);
                cxion.commit();
            }
        } catch (SQLException e) {
            if (cxion != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    cxion.rollback();
                } catch (SQLException rollbackException) {
                    System.err.print(rollbackException.toString());
                }
            }
        }
        return users;
    }
}
