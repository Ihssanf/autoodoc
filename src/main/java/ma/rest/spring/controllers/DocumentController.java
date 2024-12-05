package ma.rest.spring.controllers;

import ma.rest.spring.entities.Document;
import ma.rest.spring.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private DocumentRepository documentRepository;

    @GetMapping
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Document getDocumentById(@PathVariable Long id) {
        return documentRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Document createDocument(@RequestBody Document document) {
        return documentRepository.save(document);
    }

    @PutMapping("/{id}")
    public Document updateDocument(@PathVariable Long id, @RequestBody Document documentDetails) {
        Document document = documentRepository.findById(id).orElse(null);
        if (document != null) {
            document.setDateDeCreation(documentDetails.getDateDeCreation());
            document.setContexte(documentDetails.getContexte());
            return documentRepository.save(document);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable Long id) {
        documentRepository.deleteById(id);
    }
}
