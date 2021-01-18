package com.sskorupski.learn.user;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDAO {
    ArrayList<User> getAll() throws SQLException;
}
