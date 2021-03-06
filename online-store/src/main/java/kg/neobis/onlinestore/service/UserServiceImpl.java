package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.*;
import kg.neobis.onlinestore.model.UserAuth;
import kg.neobis.onlinestore.model.UserModel;
import kg.neobis.onlinestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getMy(String userLogin) {
        User user = getByLogin(userLogin);
        return user;
    }

    @Override
    public User create(UserModel userModel) { //при создании user'a создается userRole, Cart
        User user = new User();
        Address address = addressService.getById(userModel.getAddressId());
        if(address != null){
            user.setPassword(passwordEncoder.encode(userModel.getPassword()));
            user.setLogin(userModel.getLogin());
            user.setAddress(address);
            user.setEmail(userModel.getEmail());
            user.setIsActive(userModel.getIsActive());
            user.setPhoneNumber(userModel.getPhoneNumber());
            user = userRepository.save(user);
            UserRole userRole = new UserRole();
            userRole.setRoleName("ROLE_CUSTOMER"); //вначале все юзеры customer.
            userRole.setUser(user);
            userRoleService.create(userRole);
            Cart cart = new Cart();
            cart.setUser(user);
            cartService.create(cart);
            Order order = new Order();
            order.setUser(user);
            orderService.create(order);
        }
        return user;
    }

    @Override
    public String getToken(UserAuth userAuth) {
        User user = getByLogin(userAuth.getLogin());
        if(user == null) return "Error";
        String rawPassword = userAuth.getPassword(); //1234
        String encodedPassword = user.getPassword(); //$2a$10$6Sjvje7MmdCTUhQySkOfg.hTXT2WAA.tXKr64S
        if(passwordEncoder.matches(rawPassword, encodedPassword)){
            String loginPasswordPair = userAuth.getLogin() + ":" + userAuth.getPassword();
            String token = Base64.getEncoder().encodeToString(loginPasswordPair.getBytes());
            return "Basic " + token;
        }
        return "Error";
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLogin(login).orElse(null);
    }
}
