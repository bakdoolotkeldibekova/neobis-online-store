package kg.neobis.onlinestore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "cart_item")
public class CartItem extends BaseEntity {
    @Column(name = "product_quantity", nullable = false)
    private Integer productQuantity;
    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @ManyToOne
    @JoinColumn(name = "cart")
    private Cart cart;
}
