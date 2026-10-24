import '../../styles/learning.css';
import { useEffect, useState } from "react";
import PageHeading from "../../components/utils/PageHeading";
import Searchbar from "../../components/utils/Seachbar";
import { useAuth } from '../../components/context/AuthContext';
import { api } from '../../api';
import SkillCard from '../../components/utils/SkillCard';
import { useNavigate } from 'react-router-dom';

export default function Learning() {
    const navigate = useNavigate();
    const { user } = useAuth();
    const [learningSkills, setLearningSkills] = useState(null);

    useEffect(() => {
        const controller = new AbortController();

        api('/api/user-skills/my-learning', { method: "GET" })
            .then(skills => setLearningSkills(skills))
            .catch(() => setLearningSkills(null));

        return () => {
            controller.abort();
        };
    }, [user]);

    function handleOnContinue(userSkill) {
        navigate('/explore', {
            state: {
                skillId: userSkill.skillId
            }
        });
    }

    async function searchUserSkill(skillString) {
        if (!skillString) return;
        
        try {
            const data = await api(`/api/search/user-skill/${skillString}`, { method: "GET" });
            if (data.length > 0) {
                setLearningSkills(data);
                console.log(data);
            }
        }
        catch (e) {
            console.log(e);
        }
    }

    return (
        <div className="my-learning-page">
            <PageHeading subHeading="Let's continue where you left of" heading="Continue your learning."/>
            <Searchbar onClick={searchUserSkill} />

            {learningSkills && 
                <div className="learning-skills">
                    <h3>My learning</h3>

                    <div className="skillcard-container">
                        {learningSkills.map(userSkill => (
                            <SkillCard 
                                key={userSkill.id}
                                title={userSkill.name}
                                subtitle={`${userSkill.doneTasks} completed out of ${userSkill.totalTasks}`}
                                icon={userSkill.icon}
                                buttonText="Continue"
                                onClick={() => {handleOnContinue(userSkill)}}
                            />
                        ))}
                    </div>
                </div>
            }
        </div>
    );
}