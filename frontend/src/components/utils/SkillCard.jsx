import '../../styles/skillcard.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faArrowRight } from '@fortawesome/free-solid-svg-icons';
import SkillIcon from './SkillIcon';


export default function SkillCard({ title, subtitle, icon, buttonText, onClick}) {
    return (
        <div className="skill-card">
            <SkillIcon iconName={icon} />
            <div className="info">
                <h6>{title}</h6>
                <p>{subtitle}</p>
            </div>
            <button onClick={onClick}><p>{buttonText}</p><FontAwesomeIcon icon={faArrowRight} size="md" /></button>
        </div>
    );
}