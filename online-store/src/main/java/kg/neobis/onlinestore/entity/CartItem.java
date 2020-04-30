//package kg.neobis.onlinestore.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//
//@Entity
//@Table(name = "cart_item")
//public class CartItem extends BaseEntity {
//    @Column(name = "book_quantity", nullable = false)
//    private Integer bookQuantity;
//    @OneToOne
//    @JoinColumn(name = "book_id", nullable = false)
//    private Book book;
//    @ManyToOne
//    @JoinColumn(name = "cart")
//    private Cart cart;
//}
