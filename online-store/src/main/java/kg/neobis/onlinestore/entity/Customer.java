package kg.neobis.onlinestore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "customer")
public class Customer extends User{
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
}