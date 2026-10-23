import '../../styles/progressCard.css';

export default function ProgressCard({ totalTasks, completedTasks, xpEarned }) {
    const percentage = totalTasks > 0 ? Math.round((completedTasks / totalTasks) * 100) : 0;

    const size = 160;
    const strokeWidth = 10;
    const radius = (size - strokeWidth) / 2;
    const circumference = 2 * Math.PI * radius;
    const strokeDashoffset = circumference - (percentage / 100) * circumference;

    return (
        <div className="progress-card">
            <div className="card-header">
                <h2>Your progress</h2>
                <span>YOU GOT THIS</span>
            </div>

            <div className="circle-wrapper" style={{ width: size, height: size }}>
                <svg width={size} height={size} viewBox={`0 0 ${size} ${size}`} >
                    <circle 
                        className="circle-bg"
                        cx={size / 2}
                        cy={size / 2}
                        r={radius}
                        strokeWidth={strokeWidth}
                    />

                    <circle
                        className="circle-progress"
                        cx={size / 2}
                        cy={size / 2}
                        r={radius}
                        strokeWidth={strokeWidth}
                        strokeDasharray={circumference}
                        strokeDashoffset={strokeDashoffset}
                        strokeLinecap="round"
                    />
                </svg>

                <div className="circle-content">
                    <span className="percentage-text">{percentage}%</span>
                    <span className="subtext">Completed</span>
                </div>
            </div>

            <p className="quote" >Every expert was once a beginner.</p>

            <div className="divider" />

            <div className="card-footer">
                <div className="stat-item">
                    <p className="stat-value">
                        <span className="highlight-num">{completedTasks}</span>
                        <span className="total-num"> / {totalTasks}</span>
                    </p>
                    <p className="stat-label">Lessons done</p>
                </div>

                <div className="stat-item text-right">
                    <p className="stat-value xp">
                        <span className="highlight-num">{xpEarned}</span>
                        <span className="xp-tag"> XP</span>
                    </p>
                    <p className="stat-label">Points earned</p>
                </div>
            </div>
        </div>
    );
}