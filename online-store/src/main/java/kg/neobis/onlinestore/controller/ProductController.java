package kg.neobis.onlinestore.controller;

import kg.neobis.onlinestore.entity.Product;
import kg.neobis.onlinestore.model.ProductModel;
import kg.neobis.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

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
    public Product create(@RequestBody ProductModel productModel) {
        return productService.create(productModel);
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
