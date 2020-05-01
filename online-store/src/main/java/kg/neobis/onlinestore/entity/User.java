package kg.neobis.onlinestore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    @Column(name = "login", nullable = false, unique = true)
    private String login;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Column(name = "is_active", nullable = false)
    private Integer isActive; //0-inactive, 1-active...
}