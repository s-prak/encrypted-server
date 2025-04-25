import React, { useEffect, useState } from 'react';

const DocsList = () => {
  const [docs, setDocs] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch('http://13.203.157.202:8080/document/get-all-docs')
      .then(response => response.json())
      .then(data => {
	console.log(data);
        setDocs(data);
        setLoading(false);
      })
      .catch(error => {
        console.error('Error fetching documents:', error);
        setLoading(false);
      });
  }, []);

  if (loading) {
    return <div>Loading...</div>;
  }

  return (
    <div className="docs-container">
      {docs.map((doc, index) => (
        <div className="doc-card" key={index}>
          <div className="doc-ids">
            <div className="doc-id">{doc.id}</div>
            <div className="doc-id">{doc.docId}</div>
          </div>
          <pre className="doc-content">{JSON.stringify(doc.doc, null, 2)}</pre>
        </div>
      ))}
    </div>
  );
};

export default DocsList;
