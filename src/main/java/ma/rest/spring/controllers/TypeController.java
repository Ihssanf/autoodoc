package ma.rest.spring.controllers;

import ma.rest.spring.entities.Type;
import ma.rest.spring.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class TypeController {

    @Autowired
    private TypeRepository typeRepository;

    @GetMapping
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Type getTypeById(@PathVariable Long id) {
        return typeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Type createType(@RequestBody Type type) {
        return typeRepository.save(type);
    }

    @PutMapping("/{id}")
    public Type updateType(@PathVariable Long id, @RequestBody Type typeDetails) {
        Type type = typeRepository.findById(id).orElse(null);
        if (type != null) {
            type.setNom(typeDetails.getNom());
            type.setDescription(typeDetails.getDescription());
            return typeRepository.save(type);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteType(@PathVariable Long id) {
        typeRepository.deleteById(id);
    }
}
