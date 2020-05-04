package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.User;
import kg.neobis.onlinestore.entity.UserRole;
import kg.neobis.onlinestore.model.UserRoleModel;
import kg.neobis.onlinestore.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserService userService;

    @Override
    public List<UserRole> getAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole create(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole create(UserRoleModel userRoleModel) {
        User user = userService.getById(userRoleModel.getUserId());
        if(user == null) return null;
        UserRole userRole = new UserRole();
        userRole.setRoleName(userRoleModel.getRoleName());
        userRole.setUser(user);
        return userRoleRepository.save(userRole);
    }

    @Override
    public void deleteById(Long id) {
        userRoleRepository.deleteById(id);
    }

    @Override
    public UserRole update(UserRoleModel userRoleModel) {
        User user = userService.getById(userRoleModel.getUserId());
        if(user == null) return null;
        UserRole userRole = new UserRole();
        userRole.setRoleName(userRoleModel.getRoleName());
        userRole.setUser(user);
        return userRoleRepository.save(userRole);
    }
}
