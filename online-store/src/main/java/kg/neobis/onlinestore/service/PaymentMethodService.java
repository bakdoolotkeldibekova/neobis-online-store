package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.PaymentMethod;

import java.util.List;

public interface PaymentMethodService {
    PaymentMethod create(PaymentMethod paymentMethod);
    List<PaymentMethod> getAll();
    PaymentMethod getById(Long id);
    PaymentMethod deleteById(Long id);
}
