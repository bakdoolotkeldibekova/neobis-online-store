package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.User;
import kg.neobis.onlinestore.model.UserAuth;
import kg.neobis.onlinestore.model.UserModel;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(Long id);
    User create(User user);
    User create(UserModel userModel);
    String getToken(UserAuth userAuth);
    User getByLogin(String login);
}
