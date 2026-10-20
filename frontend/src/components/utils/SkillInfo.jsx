import '../../styles/skillInfo.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faBook, faTriangleExclamation } from '@fortawesome/free-solid-svg-icons';
import SkillIcon from '../../components/utils/SkillIcon';

export default function SkillInfo({ skill }) {
    const difficulty = skill.difficulty.charAt(0).toUpperCase() + skill.difficulty.slice(1).toLowerCase();

    return (
        <div className="skill-info-box">
            <div className="skill-info">
                <div className="category">{skill.category}</div>
                <h2>{skill.name}</h2>
                <p className="description" >{skill.description}</p>

                <div className="skill-stats">
                    <div className="skill-stat">
                        <FontAwesomeIcon icon={faBook} />
                        <p>{skill.totalTasks} lessons</p>
                    </div>

                    <div className="skill-stat">
                        <FontAwesomeIcon icon={faTriangleExclamation} />
                        <p>{difficulty}</p>
                    </div>
                </div>
            </div>

            <div className="skill-icon">
                <SkillIcon iconName={skill.icon} size="9x" />
            </div>
        </div>
    );
}