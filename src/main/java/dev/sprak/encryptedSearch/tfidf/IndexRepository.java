package dev.sprak.encryptedSearch.tfidf;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IndexRepository extends MongoRepository<IndexModel,String> {
}
