package dev.sprak.encryptedSearch.tfidf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tfidf")
@Getter
@Setter
public class IndexModel {
    @Id
    private String id;
    private String index;
}
