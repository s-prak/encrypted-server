# Full MongoDB Documentation for Encrypted Server

This document provides a comprehensive guide to MongoDB operations for all APIs in the **Encrypted Server** backend. It includes **Java-based implementations**, **raw MongoDB shell commands**, and **API endpoint mappings** for each operation.

---

## Collections and Their Fields

### 1. **Document Collection**
#### **Name**: `document`
#### **Fields**:
- **`id`**:
  - Type: `ObjectId`
  - Description: MongoDB's unique identifier for the document.
- **`docId`**:
  - Type: `String`
  - Description: The unique identifier for the document provided by the user.
- **`doc`**:
  - Type: `String`
  - Description: The encrypted content of the document.

#### **Java Model**:
```java
@Document(collection = "document")
public class DocModel {
    @Id
    private String id;
    private String docId;
    private String doc;
}
```

---

### 2. **TF-IDF Index Collection**
#### **Name**: `tfidf`
#### **Fields**:
- **`id`**:
  - Type: `ObjectId`
  - Description: MongoDB's unique identifier for the index.
- **`index`**:
  - Type: `String`
  - Description: Encrypted TF-IDF inverted index.

#### **Java Model**:
```java
@Document(collection = "tfidf")
public class IndexModel {
    @Id
    private String id;
    private String index;
}
```

---

## API Operations and Their Corresponding MongoDB Operations

### 1. **Document Management APIs**

#### **1.1 Get a Document**
- **API Endpoint**: `GET /document/get-doc`
- **Description**: Retrieve a specific encrypted document by its `docId`.

##### **Java Implementation**:
```java
@Autowired
private DocRepository docRepository;

public Optional<DocModel> getDocument(String docId) {
    return docRepository.findByDocId(docId);
}
```

##### **Raw MongoDB Shell Equivalent**:
1. Open the terminal and type:
   ```bash
   mongosh
   ```
2. Switch to the database:
   ```bash
   use projdb
   ```
3. Query the document collection:
   ```javascript
   db.document.findOne({
       docId: "12345"
   });
   ```

---

#### **1.2 Get All Documents**
- **API Endpoint**: `GET /document/get-all-docs`
- **Description**: Retrieve a list of all encrypted documents.

##### **Java Implementation**:
```java
@Autowired
private DocRepository docRepository;

public List<DocModel> getAllDocuments() {
    return docRepository.findAll();
}
```

##### **Raw MongoDB Shell Equivalent**:
1. Query all documents in the collection:
   ```javascript
   db.document.find().toArray();
   ```

---

#### **1.3 Upload a Document**
- **API Endpoint**: `POST /document/post-doc`
- **Description**: Upload a new encrypted document.

##### **Java Implementation**:
```java
@Autowired
private DocRepository docRepository;

public void saveDocument(String docId, String encryptedContent) {
    DocModel doc = new DocModel();
    doc.setDocId(docId);
    doc.setDoc(encryptedContent);
    docRepository.save(doc);
}
```

##### **Raw MongoDB Shell Equivalent**:
1. Insert a new document:
   ```javascript
   db.document.insertOne({
       docId: "12345",
       doc: "encrypted_content_here"
   });
   ```

---

### 2. **TF-IDF Index Management APIs**

#### **2.1 Get the Inverted Index**
- **API Endpoint**: `GET /inverted-index/get-index`
- **Description**: Retrieve the current TF-IDF inverted index.

##### **Java Implementation**:
```java
@Autowired
private IndexRepository indexRepository;

public List<IndexModel> getIndex() {
    return indexRepository.findAll();
}
```

##### **Raw MongoDB Shell Equivalent**:
1. Query all indices in the collection:
   ```javascript
   db.tfidf.find().toArray();
   ```

---

#### **2.2 Upload an Inverted Index**
- **API Endpoint**: `POST /inverted-index/post-index`
- **Description**: Upload a new encrypted TF-IDF inverted index.

##### **Java Implementation**:
```java
@Autowired
private IndexRepository indexRepository;

public void saveIndex(String indexContent) {
    IndexModel index = new IndexModel();
    index.setIndex(indexContent);
    indexRepository.save(index);
}
```

##### **Raw MongoDB Shell Equivalent**:
1. Insert a new index:
   ```javascript
   db.tfidf.insertOne({
       index: "encrypted_index_here"
   });
   ```

---

## Additional Raw MongoDB Shell Commands

### Create a Collection
To create a new collection in the database:
```javascript
db.createCollection("new_collection_name");
```

### Drop a Collection
To delete an entire collection and all its documents:
```javascript
db.collection_name.drop();
```

### Delete Multiple Documents
To delete all documents that match a specific condition:
```javascript
db.collection_name.deleteMany({
    field_name: "value_to_match"
});
```

### Delete a Single Document
To delete the first document that matches a specific condition:
```javascript
db.collection_name.deleteOne({
    field_name: "value_to_match"
});
```

### List All Collections
To view all collections in the current database:
```javascript
show collections;
```

### Count Documents in a Collection
To count how many documents exist in a collection:
```javascript
db.collection_name.countDocuments();
```

---

## Summary of API and MongoDB Operations

| **API Endpoint**                  | **Operation**                    | **Java Method**               | **MongoDB Shell Command**                                                                 |
|-----------------------------------|-----------------------------------|--------------------------------|------------------------------------------------------------------------------------------|
| `GET /document/get-doc`           | Retrieve a document by `docId`   | `findByDocId(docId)`          | `db.document.findOne({ docId: "12345" });`                                               |
| `GET /document/get-all-docs`      | Retrieve all documents           | `findAll()`                   | `db.document.find().toArray();`                                                         |
| `POST /document/post-doc`         | Upload a document                | `save(docModel)`              | `db.document.insertOne({ docId: "12345", doc: "encrypted_content_here" });`             |
| `GET /inverted-index/get-index`   | Retrieve all TF-IDF indices      | `findAll()`                   | `db.tfidf.find().toArray();`                                                            |
| `POST /inverted-index/post-index` | Upload a TF-IDF index            | `save(indexModel)`            | `db.tfidf.insertOne({ index: "encrypted_index_here" });`                                 |

---

## Notes
- For **Java implementations**, the `DocRepository` and `IndexRepository` interfaces extend `MongoRepository`, which provides built-in methods such as `findAll()`, `save()`, and `findById()`.
- For **raw MongoDB shell operations**, ensure you are connected to the correct database (`use projdb`) and have the appropriate permissions to read/write to the collections.
