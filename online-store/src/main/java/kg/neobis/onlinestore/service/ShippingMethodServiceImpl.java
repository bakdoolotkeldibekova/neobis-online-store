package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.ShippingMethod;
import kg.neobis.onlinestore.repository.ShippingMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingMethodServiceImpl implements ShippingMethodService {
    @Autowired
    private ShippingMethodRepository shippingMethodRepository;

    @Override
    public ShippingMethod create(ShippingMethod shippingMethod) {
        return shippingMethodRepository.save(shippingMethod);
    }

    @Override
    public ShippingMethod update(ShippingMethod shippingMethod) {
        return shippingMethodRepository.save(shippingMethod);
    }

    @Override
    public void deleteById(Long id) {
        shippingMethodRepository.deleteById(id);
    }

    @Override
    public ShippingMethod getById(Long id) {
        return shippingMethodRepository.findById(id).orElse(null);
    }

    @Override
    public List<ShippingMethod> getAll() {
        return shippingMethodRepository.findAll();
    }
}
