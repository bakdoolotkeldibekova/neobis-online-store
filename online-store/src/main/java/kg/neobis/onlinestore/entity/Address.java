package kg.neobis.onlinestore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "address")
public class Address extends BaseEntity{
    @Column(name = "country", nullable = false)
    private String country;
    @Column(name = "region", nullable = false)
    private String region;
    @Column(name = "exact_address", nullable = false)
    private String exactAddress;
}