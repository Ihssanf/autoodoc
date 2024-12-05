package ma.rest.spring.entities;




import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    private Date dateDeCreation;

    private String contexte;

    @ManyToOne
    private User utilisateur;

    @ManyToOne
    private Modele modele;
}
