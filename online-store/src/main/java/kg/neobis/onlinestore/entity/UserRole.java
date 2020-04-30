package kg.neobis.onlinestore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "user_role")
public class UserRole extends BaseEntity{
    @Column(name = "role_name", nullable = false)
    private String roleName;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

