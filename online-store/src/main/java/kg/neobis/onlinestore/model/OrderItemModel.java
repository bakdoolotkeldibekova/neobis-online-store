package kg.neobis.onlinestore.model;

import kg.neobis.onlinestore.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemModel {
    private Integer productQuantity;
    private Product product;
}
