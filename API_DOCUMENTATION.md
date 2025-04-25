# API Documentation for Encrypted Server

This document provides a detailed description of the available APIs in the **Encrypted Server** backend system. All data in this system is encrypted, and the server operates on the principles of **zero-knowledge**, meaning it has no access to the actual content of the documents, queries, or keywords. Below, you'll find the API endpoints, their functionalities, and examples for usage.

---

## General Characteristics
- **Encryption**: All data transmitted through the APIs is encrypted using strong cryptographic algorithms.
- **Zero-Knowledge**: The server only processes encrypted data and has no access to unencrypted information.

---

## Endpoints

### 1. **Document Management**

#### **1.1 Get a Document**
- **Endpoint**: `GET /document/get-doc`
- **Description**: Retrieve a specific encrypted document by its ID.
- **Request Parameters**:
  - `docId`: (String) The unique identifier of the document.
- **Response**:
  - Status 200: Returns the encrypted document.
  - Status 404: Document not found.
- **Example**:
  ```bash
  curl -X GET "https://13.203.157.202:8080/document/get-doc?docId=encrypted_id"
  ```

#### **1.2 Get All Documents**
- **Endpoint**: `GET /document/get-all-docs`
- **Description**: Retrieve a list of all encrypted documents.
- **Response**:
  - Status 200: Returns a list of encrypted documents.
  - Status 204: No documents available.
- **Example**:
  ```bash
  curl -X GET "https://13.203.157.202:8080/document/get-all-docs"
  ```

#### **1.3 Upload a Document**
- **Endpoint**: `POST /document/post-doc`
- **Description**: Upload a new encrypted document.
- **Request Body**:
  - `docId`: (String) The unique identifier of the document.
  - `content`: (String) The encrypted content of the document.
- **Response**:
  - Status 200: Document uploaded successfully.
- **Example**:
  ```bash
  curl -X POST "https://13.203.157.202:8080/document/post-doc" \
       -H "Content-Type: application/json" \
       -d '{
             "docId": "encrypted_id",
             "content": "encrypted_content"
           }'
  ```

---

### 2. **TF-IDF Index Management**

#### **2.1 Get the Inverted Index**
- **Endpoint**: `GET /inverted-index/get-index`
- **Description**: Retrieve the current TF-IDF inverted index.
- **Response**:
  - Status 200: Returns the encrypted inverted index.
  - Status 204: No index available.
- **Example**:
  ```bash
  curl -X GET "https://13.203.157.202:8080/inverted-index/get-index"
  ```

#### **2.2 Upload an Inverted Index**
- **Endpoint**: `POST /inverted-index/post-index`
- **Description**: Upload a new encrypted TF-IDF inverted index.
- **Request Body**:
  - `indexId`: (String) The unique identifier of the index.
  - `content`: (String) The encrypted content of the index.
- **Response**:
  - Status 200: Index uploaded successfully.
- **Example**:
  ```bash
  curl -X POST "https://13.203.157.202:8080/inverted-index/post-index" \
       -H "Content-Type: application/json" \
       -d '{
             "indexId": "67890",
             "content": "encrypted_index_here"
           }'
  ```

---

