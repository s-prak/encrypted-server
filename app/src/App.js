import React from 'react';
import './App.css';
import DocsList from './DocsList';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1 className="neon-heading">Encrypted Cloud Server</h1>
      </header>
      <DocsList />
    </div>
  );
}

export default App;