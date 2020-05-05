package kg.neobis.onlinestore.boot;

import kg.neobis.onlinestore.entity.Address;
import kg.neobis.onlinestore.entity.User;
import kg.neobis.onlinestore.entity.UserRole;
import kg.neobis.onlinestore.model.UserModel;
import kg.neobis.onlinestore.model.UserRoleModel;
import kg.neobis.onlinestore.service.AddressService;
import kg.neobis.onlinestore.service.UserRoleService;
import kg.neobis.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/** То что будет выполнено после запуска приложения
 *  создается user-ADMIN**/

@Component
public class Init implements CommandLineRunner {
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @Override
    public void run(String... args) throws Exception {
//        Address a = addressService.create(new Address("Kyrgyzstan", "Talas", "Tynalieva. Baba-Ata 45A"));
//        User u = userService.create(new UserModel("alex", "alex", "alex@gmail.com", "+996770551123", a.getId(), 1));
//        userRoleService.update(new UserRole("ROLE_ADMIN", u));
    }
}
