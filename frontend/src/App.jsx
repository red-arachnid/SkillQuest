import Login from './pages/Login';
import Signup from './pages/Signup';
import DashboardLayout from './pages/DashboardLayout';
import { Navigate, Route, Routes } from 'react-router-dom';
import { useAuth } from './components/context/AuthContext';
import Explore from './pages/DashboardPages/Explore';

export default function App() {
  return (
  <Routes>
    {/* <Route path="/" element={<ProtectedRoute><Dashboard /></ProtectedRoute>} />
    <Route path="/login" element={<PublicRoute><Login /></PublicRoute>} />
    <Route path="/signup" element={<PublicRoute><Signup /></PublicRoute>} /> */}
    <Route path="/" element={<DashboardLayout />}>
      <Route index element={<Navigate to="/explore" replace />} />

      <Route path="explore" element={<Explore />} />
    </Route>
  </Routes>
  );
}

function ProtectedRoute({ children }) {
  const { user } = useAuth();
  return user ? children : <Navigate to="/login" replace />
}

function PublicRoute({ children }) {
  const { user } = useAuth();
  return user ? <Navigate to="/" replace /> : children;
}