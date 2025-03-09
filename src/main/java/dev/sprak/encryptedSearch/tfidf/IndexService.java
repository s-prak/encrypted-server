package dev.sprak.encryptedSearch.tfidf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IndexService {
    @Autowired
    private IndexRepository repository;

    public Optional<IndexModel> getIndex() {
        return repository.findAll().stream().findFirst();
    }

    public IndexModel saveIndex(IndexModel newIndex) {
        repository.deleteAll(); // Ensure only one index exists
        return repository.save(newIndex);
    }
}
