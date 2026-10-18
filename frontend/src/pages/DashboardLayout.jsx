import '../styles/main.css';
import Sidebar from "../components/Sidebar";
import Header from '../components/Header';
import { Outlet } from 'react-router-dom';
import { useAuth } from '../components/context/AuthContext';

export default function DashboardLayout() {
    const { user } = useAuth();
    const profileName = getProfileName(user.name);


    function getProfileName(username) {
        const words = username.trim().split(/\s+/).filter(Boolean);
        if (words.length === 0) return "";
        if (words.length === 1) return words[0].slice(0, 2);
        return words[0][0] + words[1][0];
    }

    return (
        <div className="main">
            <Sidebar profileName={profileName} />

            <div className="content">
                <Header profileName={profileName} />

                <div className="page-body">
                    <Outlet />
                </div>
            </div>
        </div>
    );
}