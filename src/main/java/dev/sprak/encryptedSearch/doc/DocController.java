package dev.sprak.encryptedSearch.doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/document")
public class DocController {

    @Autowired
    private DocService docService ;

    @GetMapping("/get-doc")
    public ResponseEntity<DocModel> getDocument(@RequestParam String docId) {
        Optional<DocModel> document = docService.getDocumentByDocId(docId);
        return document.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/post-doc")
    public ResponseEntity<DocModel> postDocument(@RequestBody DocModel newDocument) {
        DocModel savedDocument = docService.saveDocument(newDocument);
        return ResponseEntity.ok(savedDocument);
    }

    @GetMapping("/get-all-docs")
    public ResponseEntity<List<DocModel>> getAllDocuments() {
        List<DocModel> documents = docService.getAllDocuments();
        return ResponseEntity.ok(documents);
    }

}
