import '../styles/main.css';
import Sidebar from "../components/Sidebar";
import Header from '../components/Header';


export default function Dashboard() {
    return (
        <div className="main">
            <Sidebar />

            <div className="content">
                <Header />
            </div>
        </div>
    );
}