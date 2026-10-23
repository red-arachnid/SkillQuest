import '../styles/header.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import ProfileIcon from './utils/ProfileIcon';
import { faBell } from '@fortawesome/free-regular-svg-icons'
import { faFireFlameCurved, faBolt } from '@fortawesome/free-solid-svg-icons'
import { useAuth } from './context/AuthContext';

export default function Header({ profileName }) {
    const { user, logout } = useAuth();
    const streak = user.currentStreak ?? 0;

    function onProfileClick() {
        const ask = confirm("Do you really want to log out?");
        if (ask) logout();
    }

    return (
        <div className="header">
            <div className="header-left">
                <p>Explore Skills</p>
            </div>
            
            <div className="header-right">
                <StyledInfo 
                    icon={faFireFlameCurved} 
                    iconColor={(streak > 0) ? "var(--ui1)" : "hsl(3, 14%, 29%)"} 
                    text={(streak > 1) ? `${streak} days streak` : `${streak} day streak`}
                    backgroundColor="var(--ui5)"
                />

                <StyledInfo 
                    icon={faBolt} 
                    iconColor="var(--ui1)" 
                    text={`${user.userXp} XP`} 
                    backgroundColor="var(--ui2)"
                />

                <div className="bar"></div>

                <div className="notification">
                    <FontAwesomeIcon icon={faBell} size="md"/>
                </div>

                <button className="clickable" onClick={onProfileClick}>
                    <ProfileIcon profileName={profileName}/>
                </button>
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