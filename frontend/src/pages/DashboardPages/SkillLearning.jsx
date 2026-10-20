import '../../styles/skillLearning.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import SkillInfo from '../../components/utils/SkillInfo';

export default function SkillLearning({ skill }) {

    if (!skill) return null;


    return (
        <div className="skill-learning">
            <div className="main">
                <SkillInfo skill={skill} />

                <h3>Your Learning path</h3>
            </div>

            <div className="stats">

            </div>
        </div>
    ); 
}