package kg.neobis.onlinestore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "cart")
public class Cart extends BaseEntity{
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
