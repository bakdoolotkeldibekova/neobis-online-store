package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.Product;
import kg.neobis.onlinestore.model.ProductModel;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(Long id);
    Product create(Product product);
    Product create(ProductModel productModel, String userLogin);
    Product update(Product product);
    Product deleteById(Long id);

    List<Product> getAllByName(String name);
    List<Product> getAllByPrice(Integer from, Integer to);
    List<Product> getAllByCategoryName(String categoryName);
    List<Product> getAllByDateTimeAfter(LocalDateTime dateTime);
}
