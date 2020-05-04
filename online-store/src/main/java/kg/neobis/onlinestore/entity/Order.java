package kg.neobis.onlinestore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "orders")
public class Order extends BaseEntity{
    @Column(name = "status")
    private String status;
    @Column(name = "amount")
    private Integer amount;
    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;
    @ManyToOne
    @JoinColumn(name = "shipping_method_id")
    private ShippingMethod shippingMethod;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
