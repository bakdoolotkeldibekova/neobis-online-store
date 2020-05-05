package kg.neobis.onlinestore.repository;

import kg.neobis.onlinestore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByNameContainingIgnoringCase(String name);
    List<Product> findAllByPriceBetween(Integer from, Integer to);
    List<Product> findAllByCategory_NameContainingIgnoringCase(String categoryName);
    List<Product> findAllByDateCreatedAfter(LocalDateTime dateTime);
}
