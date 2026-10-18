import '../../styles/explore.css';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import PageHeading from "../../components/utils/PageHeading";
import Seachbar from '../../components/utils/Seachbar';
import SkillCard from '../../components/utils/SkillCard';
import { useAuth } from '../../components/context/AuthContext';
import { api } from '../../api';

import { faChessKnight } from '@fortawesome/free-solid-svg-icons'
import { useEffect, useState } from 'react';

export default function Explore() {
    const { user } = useAuth();

    const [skills, setSkills] = useState(null);
    useEffect(() => {
        if (user.lastActiveSkill) return;

        const controller = new AbortController();
        const { signal } = controller;

        api("/api/skills/browse", { method: "GET" })
            .then(skills => {
                setSkills(skills);
                console.log(skills)
            })
            .catch(() => setSkills(null));
        
        return () => {
            controller.abort();
        };
    }, [user]);

    return (
        <div className="explore-page">
            <PageHeading />
            <Seachbar />

            {skills && 
            <div className="explore-skills">
                <h3>Featured Skills</h3>

                <div className="skill-con">
                    {skills.map(skill => (
                        <SkillCard key={skill.id} title={skill.name} subtitle={`${skill.category} · ${skill.totalTasks} Lessons`} icon={skill.icon} />
                    ))}
                </div>
            </div>
            }
        </div>
    );
}
