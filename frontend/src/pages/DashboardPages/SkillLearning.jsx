import '../../styles/skillLearning.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import SkillInfo from '../../components/utils/SkillInfo';
import SkillModule from '../../components/utils/SkillModule';
import { api } from '../../api';
import { useEffect, useState } from 'react';
import { faUpRightFromSquare, faXmark } from '@fortawesome/free-solid-svg-icons';


export default function SkillLearning({ skill }) {
    const [skillModules, setSkillModules] = useState(null);
    const [showTaskDetail, setShowTaskDetail] = useState(null);

    useEffect(() => {
        if (!skill) return;

        const body = { skillId: skill.id }
        api(`/api/skill-module/${skill.id}`, { method: "GET", body })
            .then(modules => setSkillModules(modules))
            .catch((e) => console.log(e));

    }, [skill]);

    return (
        <div className="skill-learning">
            { showTaskDetail && <TaskDetails task={showTaskDetail} setShowTaskDetail={setShowTaskDetail} /> }

            <div className="main">
                <SkillInfo skill={skill} />

                <h3>Your Learning path</h3>

                {skillModules &&
                    skillModules.map(skillModule => (
                        <SkillModule key={skillModule.id} skillModule={skillModule} onTaskStart={setShowTaskDetail} />
                    ))
                }
            </div>

            <div className="stats">

            </div>
        </div>
    ); 
}

function TaskDetails({ task, setShowTaskDetail }) {
    return (
        <div className="learn-skill-box">
            <div className="learn-skill">
                <button className="close" onClick={() => setShowTaskDetail(null)}><FontAwesomeIcon icon={faXmark} /></button>
                <h1>{task.title}</h1>
                <p className="description" >{task.description}</p>
                {task.resource && 
                    <a 
                        href={task.resource.url} 
                        target="_blank" 
                        rel="noopener noreferrer" 
                        className="resource" 
                    >
                        {task.format} <FontAwesomeIcon icon={faUpRightFromSquare} />
                    </a>
                }

                {/* QUIZ */}

                <button className="done" >Mark done</button>
            </div>
        </div>
    );
}