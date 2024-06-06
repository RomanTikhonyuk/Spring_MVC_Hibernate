package service;

import model.User;
import java.util.List;


public interface UserService {
    List<User> getUsersList();

    User getUser(Long id);

    void addUser(User user);

    void deleteUser(Long id);

    void editUser(User user);
}