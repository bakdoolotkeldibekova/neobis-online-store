package kg.neobis.onlinestore.model;

import kg.neobis.onlinestore.entity.PaymentMethod;
import kg.neobis.onlinestore.entity.ShippingMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {
    private PaymentMethod paymentMethod;
    private ShippingMethod shippingMethod;
}
