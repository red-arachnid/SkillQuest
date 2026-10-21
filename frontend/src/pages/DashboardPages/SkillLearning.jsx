import '../../styles/skillLearning.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import SkillInfo from '../../components/utils/SkillInfo';
import SkillModule from '../../components/utils/SkillModule';
import { api } from '../../api';
import { useAuth } from '../../components/context/AuthContext';
import { useEffect } from 'react';


export default function SkillLearning({ skill }) {
    useEffect(() => {
        if (!skill) return;

        const body = { skillId: skill.id }
        api(`/api/skill-module/${skill.id}`, { method: "GET", body })
            .then(modules => console.log(modules))
            .catch((e) => console.log(e));

    }, [skill]);

    if (!skill) return null;
    
    return (
        <div className="skill-learning">
            <div className="main">
                <SkillInfo skill={skill} />

                <h3>Your Learning path</h3>

                {/* <SkillModule skillId={skill.id} /> */}
            </div>

            <div className="stats">

            </div>
        </div>
    ); 
}