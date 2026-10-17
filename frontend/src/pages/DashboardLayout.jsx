import '../styles/main.css';
import Sidebar from "../components/Sidebar";
import Header from '../components/Header';
import { Outlet } from 'react-router-dom';


export default function DashboardLayout() {
    return (
        <div className="main">
            <Sidebar />

            <div className="content">
                <Header />

                <div className="page-body">
                    <Outlet />
                </div>
            </div>
        </div>
    );
}