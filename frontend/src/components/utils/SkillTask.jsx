import '../../styles/skillTask.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faBookOpen, faPlay, faBullseye, faTabletScreenButton, faBolt, faSquareCheck } from '@fortawesome/free-solid-svg-icons';
import { faSquare, faClock } from '@fortawesome/free-regular-svg-icons';
import { motion } from 'framer-motion';

const itemVariants = {
  hidden: { 
    opacity: 0, 
    rotateX: -90,
    originY: 0    
  },
  visible: { 
    opacity: 1, 
    rotateX: 0,  
    transition: { 
      type: "spring", 
      stiffness: 80, 
      damping: 12
    }
  },
};

export default function SkillTask({ task, onTaskStart }) {
    function getFormatIcon(format) {
        switch (format) {
            case 'READ': return faBookOpen;
            case 'VIDEO': return faPlay;
            case 'PRACTICE': return faBullseye;
            case 'INTERACTIVE': return faTabletScreenButton;
        }
    }

    return (
        <motion.div variants={itemVariants} className="skill-task">
            <div className="check-box">
                <FontAwesomeIcon icon={faSquare} size="lg" />
            </div>

            <div className="task-details">
                <h4>{task.title}</h4>
                <p className="description" >{task.description}</p>
                <div className="task-stats">
                    <div className="task-stat format">
                        <FontAwesomeIcon icon={getFormatIcon(task.format)} />
                        <p>{task.format}</p>
                    </div>

                    <div className="task-stat">
                        <FontAwesomeIcon icon={faClock} />
                        <p>{task.estimatedMinutes} min</p>
                    </div>

                    <div className="task-stat xp">
                        <FontAwesomeIcon icon={faBolt} />
                        <p>{task.taskXp}</p>
                    </div>
                </div>
            </div>

            <button className={``} onClick={() => onTaskStart(task)} >Start</button>
        </motion.div>
    );
}

