import { useState, useEffect } from 'react';

const App = () => {
  const [status, setStatus] = useState('loading');

  useEffect(() => {
    fetch('/api/health')
      .then(res => res.json())
      .then(data => setStatus(data.status))
      .catch(() => setStatus('backend not reachable'));
  }, []);

  return <h1>Backend says: {status}</h1>
};

export default App;