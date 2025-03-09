package dev.sprak.encryptedSearch.doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocService {

    @Autowired
    private DocRepository docRepository;

    public Optional<DocModel> getDocumentByDocId(String docId) {
        return docRepository.findByDocId(docId);
    }

    public DocModel saveDocument(DocModel newDocument) {
        return docRepository.save(newDocument);
    }
}
