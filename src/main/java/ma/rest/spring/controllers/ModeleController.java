package ma.rest.spring.controllers;

import ma.rest.spring.entities.Modele;
import ma.rest.spring.repositories.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modeles")
public class ModeleController {

    @Autowired
    private ModeleRepository modeleRepository;

    @GetMapping
    public List<Modele> getAllModeles() {
        return modeleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Modele getModeleById(@PathVariable Long id) {
        return modeleRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Modele createModele(@RequestBody Modele modele) {
        return modeleRepository.save(modele);
    }

    @PutMapping("/{id}")
    public Modele updateModele(@PathVariable Long id, @RequestBody Modele modeleDetails) {
        Modele modele = modeleRepository.findById(id).orElse(null);
        if (modele != null) {
            modele.setNom(modeleDetails.getNom());
            modele.setDescription(modeleDetails.getDescription());
            modele.setQuestion(modeleDetails.getQuestion());
            return modeleRepository.save(modele);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteModele(@PathVariable Long id) {
        modeleRepository.deleteById(id);
    }
}
