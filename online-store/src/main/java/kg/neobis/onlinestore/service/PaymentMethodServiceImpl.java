package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.PaymentMethod;
import kg.neobis.onlinestore.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Override
    public PaymentMethod create(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public PaymentMethod update(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public void deleteById(Long id) {
        paymentMethodRepository.deleteById(id);
    }

    @Override
    public PaymentMethod getById(Long id) {
        return paymentMethodRepository.findById(id).orElse(null);
    }

    @Override
    public List<PaymentMethod> getAll() {
        return paymentMethodRepository.findAll();
    }
}
