import { useState, useEffect } from 'react';
import Login from './pages/Login';
import Signup from './pages/Signup';
import { Route, Routes, BrowserRouter } from 'react-router-dom';

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
      </Routes>
    </BrowserRouter>
  );
}
