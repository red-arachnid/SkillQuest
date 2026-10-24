import '../../styles/explore.css';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faBolt, faXmark } from '@fortawesome/free-solid-svg-icons';
import { faClock } from '@fortawesome/free-regular-svg-icons';
import PageHeading from "../../components/utils/PageHeading";
import Seachbar from '../../components/utils/Seachbar';
import SkillCard from '../../components/utils/SkillCard';
import SkillLearning from './SkillLearning';

import { useAuth } from '../../components/context/AuthContext';
import { api } from '../../api';

import { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';

export default function Explore() {
    const { user } = useAuth();
    const location = useLocation();

    const [skills, setSkills] = useState(null);
    const [confirmSkill, setConfirmSkill] = useState(null);
    const [selectedSkillId, setSelectedSkillId] = useState(user.lastActiveSkill);

    const selectedSkill = skills?.find(s => s.id === selectedSkillId) ?? null;

    useEffect(() => {
        const controller = new AbortController();

        api("/api/skills/browse", { method: "GET" })
            .then(skills => setSkills(skills))
            .catch(() => setSkills(null));

        return () => {
            controller.abort();
        };
    }, [user]);

    useEffect(() => {
        const skillId = location.state?.skillId ?? null;
        if (skillId != null) {
            setSelectedSkillId(skillId);
        }
    }, [skills]);

    function handleSkillCardOnClick(skill) {
        if (skill.status == 'COMPLETED') return;
        if (skill.status == null) {
            setConfirmSkill(skill);
            return;
        }
        setSelectedSkillId(skill.id);
    }

    async function searchSkill(skillString) {
        if (!skillString) {
            setSelectedSkillId(null);
        }
        
        try {
            const data = await api(`/api/search/skill/${skillString}`, { method: "GET" });
            if (data.length > 0) {
                setSelectedSkillId(null);
                setSkills(data);
            }
            else {
                setSelectedSkillId(null);
            }
        }
        catch (e) {
            console.log(e);
        }
    }

    return (
        <div className="explore-page">
            { confirmSkill && <ConfirmLearningDialog skill={confirmSkill} setSelectedSkillId={setSelectedSkillId} onCancel={() => setConfirmSkill(null)}/>}

            <PageHeading subHeading={`Hey ${user.name}! Pick a skill, Let the adventure begin`} />
            <Seachbar onClick={searchSkill} />

            { selectedSkill && 
                <SkillLearning skill={selectedSkill} />
            }

            { !selectedSkill && skills && 
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


function ConfirmLearningDialog({ skill, setSelectedSkillId, onCancel }) {
    async function startLearningSkill(skill) {
        const body = {
            skillId: skill.id
        }

        try {
            await api("/api/user-skills/start", { method: "POST", body });
            setSelectedSkillId(skill.id);
        }
        catch (e) {
            // Show this error on the ui if have time :)
            alert(e.message);
        }
        finally {
            onCancel();
        }
    }

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
                        <p>{skill.skillXp} XP</p>
                    </div>
                </div>

                <button className="confirm-button" onClick={() => startLearningSkill(skill)}>Start learning</button>
            </div>
        </div>
    )
}