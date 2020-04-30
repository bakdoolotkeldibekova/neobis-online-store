//package kg.neobis.onlinestore.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//
//@Entity
//@Table(name = "order_item")
//public class OrderItem extends BaseEntity{
//    @Column(name = "book_quantity", nullable = false)
//    private Integer bookQuantity;
//    @OneToOne
//    @JoinColumn(name = "book_id", nullable = false)
//    private Book book;
//    @ManyToOne
//    @JoinColumn(name = "orders")
//    private Order order;
//}
