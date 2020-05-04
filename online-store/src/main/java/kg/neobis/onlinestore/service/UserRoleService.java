package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.UserRole;
import kg.neobis.onlinestore.model.UserRoleModel;

import java.util.List;

public interface UserRoleService {
    List<UserRole> getAll();
    UserRole create(UserRole userRole);
    UserRole create(UserRoleModel userRoleModel);
    void deleteById(Long id);
    UserRole update(UserRoleModel userRoleModel);
}
