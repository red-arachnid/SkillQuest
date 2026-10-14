import { useState, useEffect } from 'react';
import Login from './pages/Login'
import { Route, Routes, BrowserRouter } from 'react-router-dom';

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
      </Routes>
    </BrowserRouter>
  );
}
