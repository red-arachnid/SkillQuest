import '../../styles/explore.css';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import PageHeading from "../../components/utils/PageHeading";
import Seachbar from '../../components/utils/Seachbar';

export default function Explore() {
    return (
        <div className="explore-page">
            <PageHeading />
            <Seachbar />
        </div>
    );
}