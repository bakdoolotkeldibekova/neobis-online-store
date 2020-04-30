package kg.neobis.onlinestore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "author")
public class Author extends BaseEntity{
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "boigraphy", length = 500)
    private String biography;
}
