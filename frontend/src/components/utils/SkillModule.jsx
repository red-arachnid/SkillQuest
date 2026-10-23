import '../../styles/skillModule.css';
import SkillTask from './SkillTask';
import { motion } from 'framer-motion';

const containerVariants = {
  hidden: { opacity: 1 },
  visible: {
    opacity: 1,
    transition: {
      staggerChildren: 0.18, 
    },
  },
};

export default function SkillModule({ skillModule, onTaskStart }) {
    return (
        <motion.div 
            variants={containerVariants}
            initial="hidden"
            animate="visible"
            className="skill-module"
        >
            <h4>{skillModule.title}</h4>

            {skillModule.tasks.map(task => (
                <SkillTask task={task} key={task.id} onTaskStart={onTaskStart} />
            ))}
        </motion.div>
    );
}