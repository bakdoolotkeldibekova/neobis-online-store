package kg.neobis.onlinestore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "payment_method")
public class PaymentMethod extends BaseEntity{
    @Column(name = "method", nullable = false)
    private String method;
}
