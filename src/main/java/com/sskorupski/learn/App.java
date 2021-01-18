package com.sskorupski.learn;

import com.sskorupski.learn.user.SQLUserDao;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
        System.out.println( "Hello JDBC!" );
        SQLUserDao userDAO = new SQLUserDao();
        System.out.println(userDAO.getAll());
    }
}
