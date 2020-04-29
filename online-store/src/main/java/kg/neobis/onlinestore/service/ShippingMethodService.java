package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.ShippingMethod;

import java.util.List;

public interface ShippingMethodService {
    ShippingMethod create(ShippingMethod shippingMethod);
    ShippingMethod update(ShippingMethod shippingMethod);
    void deleteById(Long id);
    ShippingMethod getById(Long id);
    List<ShippingMethod> getAll();
}
