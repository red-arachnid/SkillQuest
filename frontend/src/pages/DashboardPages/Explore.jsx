import '../../styles/explore.css';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faBolt, faXmark } from '@fortawesome/free-solid-svg-icons';
import { faClock } from '@fortawesome/free-regular-svg-icons';
import PageHeading from "../../components/utils/PageHeading";
import Seachbar from '../../components/utils/Seachbar';
import SkillCard from '../../components/utils/SkillCard';
import { useAuth } from '../../components/context/AuthContext';
import { api } from '../../api';

import { useEffect, useState } from 'react';

export default function Explore() {
    const { user } = useAuth();

    const [skills, setSkills] = useState(null);
    const [activeSkill, setActiveSkill] = useState(null);

    useEffect(() => {
        if (user.lastActiveSkill) return;

        const controller = new AbortController();
        const { signal } = controller;

        api("/api/skills/browse", { method: "GET" })
            .then(skills => setSkills(skills))
            .catch(() => setSkills(null));
        
        return () => {
            controller.abort();
        };
    }, [user]);

    function handleSkillCardOnClick(skill) {
        setActiveSkill(skill);
    }

    return (
        <div className="explore-page">
            { activeSkill && <ConfirmLearning skill={activeSkill} onCancel={() => setActiveSkill(null)}/>}
            <PageHeading subHeading={`Hey ${user.name}! Pick a skill, Let the adventure begin`} />
            <Seachbar />

            {skills && 
                <div className="explore-skills">
                    <h3>Featured Skills</h3>

                    <div className="skillcard-container">
                        {skills.map(skill => (
                            <SkillCard 
                                key={skill.id} 
                                title={skill.name} 
                                subtitle={`${skill.category} · ${skill.totalTasks} Lessons`} 
                                icon={skill.icon} 
                                buttonText={skill.status == null ? "Start Learning" : "Continue" }
                                onClick={() => handleSkillCardOnClick(skill)}
                            />
                        ))}
                    </div>
                </div>
            }
        </div>
    );
}


function ConfirmLearning({ skill, onCancel }) {
    console.log(skill);
    if (!skill) return null;
    return (
        <div className="confirm-learning-box">
            <div className="confirm-learning">
                <button className="close" onClick={onCancel}><FontAwesomeIcon icon={faXmark} /></button>

                <p className="category" >{skill.category}</p>
                <h4>{skill.name}</h4>
                <p className="description">{skill.description}</p>

                <div className="skill-info">
                    <div style={{color: "var(--text-secondary)"}}>
                        <FontAwesomeIcon icon={faClock} />
                        <p>{skill.estimatedHours} hours</p>
                    </div>

                    <div style={{color: "var(--ui1)"}}>
                        <FontAwesomeIcon icon={faBolt} />
                        <p>{skill.xp} XP</p>
                    </div>
                </div>

                <button className="confirm-button" >Start learning</button>
            </div>
        </div>
    )
}