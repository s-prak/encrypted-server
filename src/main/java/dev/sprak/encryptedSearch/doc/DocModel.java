package dev.sprak.encryptedSearch.doc;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "document")
@Getter
@Setter
public class DocModel {
    @Id
    private String id;
    private String docId;
    private String doc;
}
