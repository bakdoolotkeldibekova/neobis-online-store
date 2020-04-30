//package kg.neobis.onlinestore.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//
//@Entity
//@Table(name = "orders")
//public class Order extends BaseEntity{
//    @Column(name = "status", nullable = false)
//    private String status;
//    @Column(name = "amount", nullable = false)
//    private Integer amount;
//    @ManyToOne
//    @JoinColumn(name = "payment_method_id", nullable = false)
//    private PaymentMethod paymentMethod;
//    @ManyToOne
//    @JoinColumn(name = "shipping_method_id", nullable = false)
//    private PaymentMethod shippingMethod;
//    @OneToOne
//    @JoinColumn(name = "customer_id", nullable = false)
//    private Customer customer;
//    @OneToMany(mappedBy = "orders")
//    private List<OrderItem> items = new ArrayList<OrderItem>();
//}
