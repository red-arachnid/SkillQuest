import '../styles/sidebar.css';
import { NavLink } from 'react-router-dom';
import Brand from './Brand';
import { faCompass } from '@fortawesome/free-regular-svg-icons';
import { faBookOpen, faBullseye, faGraduationCap, faBolt, faSquareArrowUpRight} from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import ProfileIcon from './utils/ProfileIcon';

export default function Sidebar() {
    function getNavClass({isActive}) {
        return isActive ? "active" : "";
    }

    return (
        <div className="sidebar">
            <Brand size='sm'/>

            <div className="sidebar-section">
                <p>LET'S GO LEARN</p>
                <div className="con">
                    <NavLink to="/explore" className={getNavClass}>
                        <FontAwesomeIcon icon={faCompass}/>
                        <p>Explore skills</p>
                    </NavLink>
                    <NavLink to="/learning" className={getNavClass}>
                        <FontAwesomeIcon icon={faBookOpen}/>
                        <p>My Learning</p>
                    </NavLink>
                </div>
            </div>

            <div className="sidebar-section">
                <p>KEEP GROWING</p>
                <div className="con">
                    <NavLink to="" className={getNavClass}>
                        <FontAwesomeIcon icon={faBullseye}/>
                        <p>Daily challenge</p>
                        <FontAwesomeIcon icon={faBolt} color="var(--ui3)"/>
                    </NavLink>
                    <NavLink to="" className={getNavClass}>
                        <FontAwesomeIcon icon={faGraduationCap}/>
                        <p>Community</p>
                        <FontAwesomeIcon icon={faSquareArrowUpRight} />
                    </NavLink>
                </div>
            </div>

            <div className="sidebar-footer">
                <div className="sidebar-profile">
                    <ProfileIcon profileName="AY" />
                    <div className="profile-info">
                        <p className="name">Aniket Yadav</p>
                        <p className="level">Curious mind · Level 1</p>
                    </div>
                </div>
            </div>
        </div>
    );
}