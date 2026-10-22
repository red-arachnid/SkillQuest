import Login from './pages/Login';
import Signup from './pages/Signup';
import DashboardLayout from './pages/DashboardLayout';
import { Navigate, Route, Routes } from 'react-router-dom';
import { useAuth } from './components/context/AuthContext';
import Explore from './pages/DashboardPages/Explore';
import Learning from './pages/DashboardPages/Learning';

export default function App() {

  return (
    <Routes>
      <Route path="/login" element={<PublicRoute><Login /></PublicRoute>} />
      <Route path="/signup" element={<PublicRoute><Signup /></PublicRoute>} />
      <Route path="/" element={<ProtectedRoute><DashboardLayout /></ProtectedRoute>}>
        <Route index element={<Navigate to="/explore" replace />} />

        <Route path="explore" element={<Explore />} />
        <Route path="learning" element={<Learning />} />
      </Route>

      <Route path="*" element={<ProtectedRoute><Navigate to="/explore" replace /></ProtectedRoute>} />
    </Routes>
  );
}

function ProtectedRoute({ children }) {
  const { user, isLoading } = useAuth();

  if (isLoading) {
    return null;
  }
  
  return user ? children : <Navigate to="/login" replace />
}

function PublicRoute({ children }) {
  const { user } = useAuth();
  return user ? <Navigate to="/" replace /> : children;
}