package kg.neobis.onlinestore.controller;

import kg.neobis.onlinestore.entity.Category;
import kg.neobis.onlinestore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Category create(@RequestBody Category category){
        return categoryService.create(category);
    }

    @GetMapping
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @DeleteMapping
    public Category deleteById(@RequestBody Long id){
        return categoryService.deleteById(id);
    }
}
