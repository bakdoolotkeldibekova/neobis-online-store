package kg.neobis.onlinestore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String status;
    @Column
    private LocalDateTime dateTime;
    @Column
    private Integer amount;
    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;
    @ManyToOne
    @JoinColumn(name = "shipping_method_id")
    private PaymentMethod shippingMethod;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany
    @JoinColumn(name = "order_item_id")
    private List<OrderItem> orderItemList;

}
