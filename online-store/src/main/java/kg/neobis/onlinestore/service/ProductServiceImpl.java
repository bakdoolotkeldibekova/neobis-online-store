package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.Category;
import kg.neobis.onlinestore.entity.Product;
import kg.neobis.onlinestore.entity.User;
import kg.neobis.onlinestore.model.ProductModel;
import kg.neobis.onlinestore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product create(ProductModel productModel, String userLogin) {
        User user = userService.getByLogin(userLogin);
        if(user == null) {
            return null;
        }
        Category category = categoryService.getById(productModel.getCategoryId());
        Product product = new Product();
        if(category != null){
            product.setName(productModel.getName());
            product.setPrice(productModel.getPrice());
            product.setCategory(category);
            productRepository.save(product);
        }
        return product;
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product deleteById(Long id) {
       Product product = getById(id);
       if(product != null ){
           productRepository.deleteById(id);
       }
       return product;
    }

    @Override
    public List<Product> getAllByName(String name) {
        return productRepository.findAllByNameContainingIgnoringCase(name);
    }

    @Override
    public List<Product> getAllByPrice(Integer from, Integer to) {
        return productRepository.findAllByPriceBetween(from, to);
    }

    @Override
    public List<Product> getAllByCategoryName(String categoryName) {
        return productRepository.findAllByCategory_NameContainingIgnoringCase(categoryName);
    }

    @Override
    public List<Product> getAllByDateTimeAfter(LocalDateTime dateTime) {
        return productRepository.findAllByDateCreatedAfter(dateTime);
    }
}
