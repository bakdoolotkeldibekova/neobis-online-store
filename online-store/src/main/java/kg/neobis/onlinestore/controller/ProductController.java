package kg.neobis.onlinestore.controller;

import kg.neobis.onlinestore.entity.Product;
import kg.neobis.onlinestore.entity.User;
import kg.neobis.onlinestore.model.ProductModel;
import kg.neobis.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{name}")
    public List<Product> getAllByName(@PathVariable String name) {
        return productService.getAllByName(name);
    }

    @GetMapping("/price")
    public List<Product> getAllByPriceBetween(@RequestParam(name = "from") Integer from, @RequestParam(name = "to") Integer to) {
        return productService.getAllByPrice(from, to);
    }

    @GetMapping("/category")
    public List<Product> getAllByCategoryName(@RequestParam(name = "name") String name) {
        return productService.getAllByCategoryName(name);
    }

    @GetMapping("/dateTime")
    public List<Product> getAllByDateTimeAfter(@RequestParam(name = "dateTime") LocalDateTime dateTime) {
        return productService.getAllByDateTimeAfter(dateTime);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        Product product = productService.getById(id);
        HttpHeaders headers = new HttpHeaders();

        if (product == null) {
            headers.add("Message", "Couldn't find product with id " + id);
            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
        }
        headers.add("Message", "OK");
        return new ResponseEntity<>(product, headers, HttpStatus.OK);
    }

    @PostMapping("/old")
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @PostMapping
    public Product create(@RequestBody ProductModel productModel, Principal principal) {
        String userLogin = principal.getName();
        return productService.create(productModel, userLogin);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping
    public Product deleteById(@RequestParam(name = "id") Long id) {
        return productService.deleteById(id);
    }
}
