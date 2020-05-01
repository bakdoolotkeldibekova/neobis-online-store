package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.User;
import kg.neobis.onlinestore.model.UserAuth;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(Long id);
    User create(User user);
    String getToken(UserAuth userAuth);
    User getByLogin(String login);
}
