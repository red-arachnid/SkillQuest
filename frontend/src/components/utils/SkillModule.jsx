import '../../styles/skillModule.css';
import SkillTask from './SkillTask';

export default function SkillModule({ skillModule, onTaskStart }) {
    return (
        <div className="skill-module">
            <h4>{skillModule.title}</h4>

            {skillModule.tasks.map(task => (
                <SkillTask task={task} key={task.id} onTaskStart={onTaskStart} />
            ))}
        </div>
    );
}