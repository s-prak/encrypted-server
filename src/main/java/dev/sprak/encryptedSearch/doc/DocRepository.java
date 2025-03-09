package dev.sprak.encryptedSearch.doc;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DocRepository extends MongoRepository<DocModel,String> {
    Optional<DocModel> findByDocId(String docId);
}
