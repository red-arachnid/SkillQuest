import '../../styles/skillTask.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faBookOpen, faPlay, faBullseye, faTabletScreenButton, faBolt, faSquareCheck } from '@fortawesome/free-solid-svg-icons';
import { faSquare, faClock } from '@fortawesome/free-regular-svg-icons';
import { motion } from 'framer-motion';
import { p } from 'framer-motion/client';

const itemVariants = {
    hidden: { 
        opacity: 0, 
        y: -20 
    },
    visible: {
        opacity: 1,
        y: 0,
        transition: {
            opacity: { 
                duration: 0 
            },
            y: { 
                type: "spring", 
                stiffness: 300, 
                damping: 14 
            },
        },
    },
    hover: {
        y: -10,
        borderColor: "var(--border2)",
        transition: {
            type: "spring",
            stiffness: 300,
            damping: 20
        }
    }
};

export default function SkillTask({ task, onTaskStart }) {
    const isDone = task.isDone;

    function getFormatIcon(format) {
        switch (format) {
            case 'READ': return faBookOpen;
            case 'VIDEO': return faPlay;
            case 'PRACTICE': return faBullseye;
            case 'INTERACTIVE': return faTabletScreenButton;
        }
    }

    return (
        <motion.div 
            variants={itemVariants} 
            whileHover={!isDone ? "hover" : ""}
            className={`skill-task ${isDone ? 'done' : ''}`}
        >
            <div className="check-box">
                <FontAwesomeIcon icon={isDone ? faSquareCheck : faSquare} size="lg" />
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

            {!isDone 
            ? <button onClick={() => onTaskStart(task)} >Start</button>
            : <p className="complete" >DONE</p>}
        </motion.div>
    );
}

