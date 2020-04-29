package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User update(User user);
    User getById(Long id);
    List<User> getAll();
    void deleteById(Long id);
}
