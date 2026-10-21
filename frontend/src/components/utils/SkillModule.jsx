import { useEffect } from 'react';
import '../../styles/skillModule.css';
import { api } from '../../api';
import { useAuth } from '../context/AuthContext';

export default function SkillModule({ skillId }) {
    const { user } = useAuth();

    return (
        <div className="skill-module">
            <h4>First Module</h4>

            <div className="skill-task">
                
            </div>
        </div>
    );
}