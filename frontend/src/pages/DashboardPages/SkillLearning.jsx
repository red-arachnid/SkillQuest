import '../../styles/skillLearning.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import SkillInfo from '../../components/utils/SkillInfo';
import SkillModule from '../../components/utils/SkillModule';
import { api } from '../../api';
import { useEffect, useState } from 'react';
import { faBolt, faUpRightFromSquare, faXmark } from '@fortawesome/free-solid-svg-icons';
import { faClock } from '@fortawesome/free-regular-svg-icons';


export default function SkillLearning({ skill }) {
    const [skillModules, setSkillModules] = useState(null);
    const [showTaskDetail, setShowTaskDetail] = useState(null);

    useEffect(() => {
        if (!skill) return;

        const body = { skillId: skill.id }
        api(`/api/skill-module/${skill.id}`, { method: "GET", body })
            .then(modules => setSkillModules(modules))
            .catch((e) => console.log(e));

    }, [skill, showTaskDetail]);

    return (
        <div className="skill-learning">
            { showTaskDetail && <TaskDetails skill={skill} task={showTaskDetail} setShowTaskDetail={setShowTaskDetail} /> }

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

function TaskDetails({ skill, task, setShowTaskDetail }) {
    const [loading, setLoading] = useState(false);
    
    async function onTaskComplete() {
        setLoading(true);

        const body = {
            "skillId": skill.id,
            "taskId": task.id
        }

        try {
            await api('/api/user-task/complete', { method: "POST", body });
            setShowTaskDetail(null);
        } 
        catch (e) {
            // Add UI if no other important task is left
            console.log(e);
        }
        finally {
            setLoading(false);
        }
    }

    return (
        <div className="learn-skill-box">
            <div className="learn-skill">
                <button className="close" onClick={() => setShowTaskDetail(null)}><FontAwesomeIcon icon={faXmark} /></button>
                <p className="skillname">{skill.name}</p>
                <h1>{task.title}</h1>
                <p className="description" >{task.description}</p>

                <div className="task-stats">
                    <div className="task-stat">
                        <FontAwesomeIcon icon={faClock} />
                        <p>{task.estimatedMinutes} mins</p>
                    </div>

                    <div className="task-stat xp">
                        <FontAwesomeIcon icon={faBolt} />
                        <p>{task.taskXp} XP</p>
                    </div>
                </div>

                <p className="description">Explore the {task.format === 'PRACTICE' ? 'task' : 'source material'} at your own pace, then complete this step when you feel ready</p>

                {task.resource && 
                    <a
                        href={task.resource.url}
                        target="_blank" 
                        rel="noopener noreferrer" 
                        className="resource" 
                    >
                        <p>{task.format}</p>
                        <FontAwesomeIcon icon={faUpRightFromSquare} />
                    </a>
                }

                <button disabled={loading} onClick={onTaskComplete} className="done">Mark done</button>
            </div>
        </div>
    );
}