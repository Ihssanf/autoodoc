package ma.rest.spring.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Modele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;
    private String description;
    private String question;

    @ManyToOne
    private Type type;

    @OneToMany(mappedBy = "modele", cascade = CascadeType.ALL)
    private List<Document> documents;
}
