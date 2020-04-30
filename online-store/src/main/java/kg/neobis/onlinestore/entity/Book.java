package kg.neobis.onlinestore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "book")
public class Book extends BaseEntity{
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "synopsis", length = 500)
    private String synopsis;
    @Column(name = "price")
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}
