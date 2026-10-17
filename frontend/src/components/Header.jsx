import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import '../styles/header.css';
import ProfileIcon from './utils/ProfileIcon';
import { faBell } from '@fortawesome/free-regular-svg-icons'
import { faFireFlameCurved, faBolt } from '@fortawesome/free-solid-svg-icons'

export default function Header() {
    return (
        <div className="header">
            <div className="header-left">
                <p>Explore Skills</p>
            </div>
            
            <div className="header-right">
                <StyledInfo 
                    icon={faFireFlameCurved} 
                    iconColor="var(--ui1)" 
                    text="2 days streak" 
                    backgroundColor="var(--ui6)"
                />

                <StyledInfo 
                    icon={faBolt} 
                    iconColor="var(--ui1)" 
                    text="120 XP" 
                    backgroundColor="var(--ui5)"
                />

                <div className="bar"></div>

                <div className="notification">
                    <FontAwesomeIcon icon={faBell} size="md"/>
                </div>

                <ProfileIcon profileName="AY"/>
            </div>
        </div>
    );
}

function StyledInfo({ icon, text, iconColor, backgroundColor }) {
    return (
        <div className="styled-info" style={{backgroundColor: backgroundColor}}>
            <FontAwesomeIcon icon={icon} color={iconColor}/>
            <p>{text}</p>
        </div>
    );
}