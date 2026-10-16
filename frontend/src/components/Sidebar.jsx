import '../styles/sidebar.css';
import { Link } from 'react-router-dom';
import Brand from './Brand';
import { faCompass } from '@fortawesome/free-regular-svg-icons';
import { faBookOpen, faBullseye, faGraduationCap, faBolt, faSquareArrowUpRight} from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

export default function Sidebar() {
    return (
        <div className="sidebar">
            <Brand size='sm'/>

            <div className="sidebar-section">
                <p>LET'S GO LEARN</p>
                <div className="con">
                    <Link to="" className="active">
                        <FontAwesomeIcon icon={faCompass}/>
                        <p>Explore skills</p>
                    </Link>
                    <Link to="" className="">
                        <FontAwesomeIcon icon={faBookOpen}/>
                        <p>My Learning</p>
                    </Link>
                </div>
            </div>

            <div className="sidebar-section">
                <p>KEEP GROWING</p>
                <div className="con">
                    <Link to="" className="">
                        <FontAwesomeIcon icon={faBullseye}/>
                        <p>Daily challenge</p>
                        <FontAwesomeIcon icon={faBolt} color="var(--ui3)"/>
                    </Link>
                    <Link to="" className="">
                        <FontAwesomeIcon icon={faGraduationCap}/>
                        <p>Community</p>
                        <FontAwesomeIcon icon={faSquareArrowUpRight} />
                    </Link>
                </div>
            </div>
        </div>
    );
}