package kg.neobis.onlinestore.controller;

import kg.neobis.onlinestore.entity.User;
import kg.neobis.onlinestore.model.UserAuth;
import kg.neobis.onlinestore.model.UserModel;
import kg.neobis.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/my")
    public User getById(Principal principal) {
        return userService.getMy(principal.getName());
    }

    @PostMapping
    public User create(@RequestBody UserModel userModel) {
        return userService.create(userModel);
    }

    @PostMapping("/auth")
    public ResponseEntity<String> getToken(@RequestBody UserAuth userAuth) {
        String result = userService.getToken(userAuth);
        if(result.equals("Error")) return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
