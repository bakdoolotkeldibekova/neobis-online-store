package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.Category;
import kg.neobis.onlinestore.entity.User;
import kg.neobis.onlinestore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserService userService;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category deleteById(Long id) {
        Category category = getById(id);
        categoryRepository.deleteById(id);
        return category; //если нет, возвращает null
    }
}
