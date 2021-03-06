package kg.neobis.onlinestore.repository;

import kg.neobis.onlinestore.entity.Cart;
import kg.neobis.onlinestore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(User user);
}
