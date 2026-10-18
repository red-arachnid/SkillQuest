import '../../styles/explore.css';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import PageHeading from "../../components/utils/PageHeading";
import Seachbar from '../../components/utils/Seachbar';
import { useAuth } from '../../components/context/AuthContext';
import { api } from '../../api';

export default function Explore() {
    const { user } = useAuth();

    AvailableSkills();

    return (
        <div className="explore-page">
            <PageHeading />
            <Seachbar />

            
        </div>
    );
}

async function AvailableSkills() {
    const data = api("/api/skills/browse", { method: "GET" });
    console.log(data);
}