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
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String imageHREF;
    @Column(length = 500)
    private String synopsis;
    @Column
    private Integer pages;
    @Column
    private LocalDate publicationDate;
    @Column
    private LocalDateTime appearDateTime;
    @Column
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

}
