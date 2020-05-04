package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.ShippingMethod;

import java.util.List;

public interface ShippingMethodService {
    List<ShippingMethod> getAll();
    ShippingMethod getById(Long id);
    ShippingMethod create(ShippingMethod shippingMethod);
    ShippingMethod deleteById(Long id);
}
