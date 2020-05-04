package kg.neobis.onlinestore.controller;

import kg.neobis.onlinestore.entity.UserRole;
import kg.neobis.onlinestore.model.UserRoleModel;
import kg.neobis.onlinestore.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-role")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @GetMapping
    public List<UserRole> getAll() {
        return userRoleService.getAll();
    }

    @PostMapping
    public UserRole create(@RequestBody UserRoleModel userRoleModel) {
        return userRoleService.create(userRoleModel);
    }

    @PostMapping("/old")
    public UserRole create(@RequestBody UserRole userRole) {
        return userRoleService.create(userRole);
    }

    @PutMapping
    public UserRole update(@RequestBody UserRoleModel userRoleModel){
        return userRoleService.update(userRoleModel);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        userRoleService.deleteById(id);
    }
}
