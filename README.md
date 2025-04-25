# Encrypted Server

Welcome to the **Encrypted Server** repository! This project is the cloud server component of a secure document management system. It is built as a Spring Boot application and provides robust backend services for handling document uploads, retrievals, and processing using state-of-the-art methods. Below, you'll find a detailed explanation of the technical aspects, functionalities, and how the system operates.

---

## Features

- **Secure Document Upload and Retrieval**: Facilitates encrypted document uploads and retrievals between the data owner and data user.
- **Cloud Integration**: Hosted on a cloud server, leveraging MongoDB for database management.
- **TF-IDF Model Integration**: Employs a TF-IDF (Term Frequency-Inverse Document Frequency) model for document analysis and processing.
- **Frontend Connectivity**: Connected to a React-based frontend application for user interaction and visualization.
- **Scalable Architecture**: Designed to handle multiple users and large datasets efficiently.

---

## Encryption and Zero-Knowledge Principles

This system is built with **end-to-end encryption** and adheres to **zero-knowledge principles**, ensuring the highest levels of security and privacy. Here's how it works:

1. **End-to-End Encryption**:
   - All documents, queries, and responses are encrypted on the client side before being transmitted to the server.
   - The server only processes and stores encrypted data, ensuring that no sensitive content is ever exposed.

2. **Zero-Knowledge Principles**:
   - The server has no knowledge of the document content, query keywords, or TF-IDF model results in their unencrypted form.
   - All computations (e.g., TF-IDF analysis) are performed on encrypted data.
   - This ensures that even if the server is compromised, sensitive information remains secure.

By combining encryption and zero-knowledge techniques, this system provides a robust framework for secure and private document management.

---

## Technical Architecture

### 1. **Spring Boot Backend**
The backend is developed using **Spring Boot**, a powerful Java framework for building scalable and production-ready applications. It serves as the core of this server-side application, providing the following features:

- **RESTful APIs**: Exposes endpoints for document upload, retrieval, and processing.
- **Security**: Implements robust authentication and authorization mechanisms to ensure data integrity and confidentiality.
- **Integration with MongoDB**: Seamlessly connects to the MongoDB cloud database for storing and retrieving document metadata and content.

### 2. **Database: MongoDB**
- **Cloud-hosted MongoDB**: The application uses a MongoDB database hosted in the cloud for storing:
  - Document metadata.
  - User information.
  - TF-IDF model results.
- **High Performance**: MongoDB's schema-less and scalable architecture ensures efficient handling of large datasets.

### 3. **Frontend: React Application**
- **React.js**: The frontend is built using React, a popular JavaScript library for building user interfaces. It connects to the backend server to:
  - Display uploaded documents.
  - Facilitate user interactions for uploading and retrieving documents.
  - Present TF-IDF analysis results in a user-friendly manner.

### 4. **TF-IDF Model**
- The backend integrates a **TF-IDF (Term Frequency-Inverse Document Frequency)** model for processing and analyzing document content.
- This model is particularly useful for:
  - Text analysis.
  - Keyword extraction.
  - Content-based document retrieval.

---

## System Workflow

1. **Document Upload**:
   - The data owner uploads a document via the React frontend.
   - The document is encrypted on the client side and securely transmitted to the Spring Boot backend.
   - Metadata and content are stored in the MongoDB database in encrypted form.

2. **Document Retrieval**:
   - The data user requests a document through the frontend.
   - The backend fetches the encrypted document from MongoDB and sends it to the user.
   - Encrypted transmission ensures data security.

3. **TF-IDF Model Processing**:
   - Documents are analyzed using the TF-IDF model on encrypted data.
   - The processed results are also stored and displayed securely.

---

## Prerequisites

### To run this project, you need:
1. **Java**: Version 11 or higher.
2. **Spring Boot**: Pre-configured in the project.
3. **MongoDB**: A cloud-hosted MongoDB instance.
4. **Node.js and NPM**: For running the React frontend.
5. **Cloud Hosting Provider**: The backend server should be deployed on a cloud server (e.g., AWS, GCP, Azure).

---

## How to Run

### Backend (Spring Boot Application)
1. Clone the repository:
   ```bash
   git clone https://github.com/s-prak/encrypted-server.git
   cd encrypted-server
   ```
2. Configure the `application.properties` file:
   - Add your MongoDB connection details.
   - Configure other necessary environment variables.
3. Build and run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

### Frontend (React Application)
1. Navigate to the frontend directory:
   ```bash
   cd app
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Start the React app:
   ```bash
   npm start
   ```

---

## Deployment

### Backend
- Deploy the Spring Boot application on a cloud hosting provider, e.g., AWS EC2, Google Cloud Compute Engine, or Azure Virtual Machines.

### Frontend
- Host the React application on a platform like Netlify or Vercel for seamless user access.

---
