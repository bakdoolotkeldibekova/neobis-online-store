package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.PaymentMethod;

import java.util.List;

public interface PaymentMethodService {
    PaymentMethod create(PaymentMethod paymentMethod);
    PaymentMethod update(PaymentMethod paymentMethod);
    void deleteById(Long id);
    PaymentMethod getById(Long id);
    List<PaymentMethod> getAll();
}
