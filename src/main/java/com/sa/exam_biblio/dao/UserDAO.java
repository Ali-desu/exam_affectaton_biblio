package com.sa.exam_biblio.dao;

import com.sa.exam_biblio.model.User;
import java.util.List;

public interface UserDAO {
    void addUser(User user);
    User getUserById(Long userId);
    List<User> getAllUsers();
    List<User> getUsersWithLoans();
}
