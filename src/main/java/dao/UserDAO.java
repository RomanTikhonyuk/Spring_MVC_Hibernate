package dao;


import model.User;
import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> getUsersList();
    User getUser(Long id);
    void addUser(User user);
    void deleteUser(Long id);
    void editUser(User user);
}