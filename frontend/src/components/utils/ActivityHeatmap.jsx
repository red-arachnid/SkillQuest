import '../../styles/heatmap.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faFireFlameCurved } from '@fortawesome/free-solid-svg-icons';
import { p } from 'framer-motion/client';

export default function ActivityHeatmap({ heatmapData }) {
    const today = new Date();
    const year = today.getFullYear();
    const month = today.getMonth();

    const daysInMonth = new Date(year, month + 1, 0).getDate();
    const firstDayOfMonth = new Date(year, month, 1).getDay();

    const startOffset = firstDayOfMonth === 0 ? 6 : firstDayOfMonth - 1;

    const activeDates = new Map(
        heatmapData.filter(d => d.count > 0).map(d => [d.date, d.count])
    );

    function renderDays() {
        const days = [];

        for (let i = 0; i < startOffset; ++i) {
            days.push(<div key={`empty-${i}`} className="day-circle empty-slot" ></div>);
        }

        let streakStarted = false;
        for (let day = 1; day <= daysInMonth; ++day) {
            const dateString = `${year}-${String(month+1).padStart(2, '0')}-${String(day).padStart(2, '0')}`;
            const logCount = activeDates.get(dateString) || 0;

            if (logCount > 0) streakStarted = true;

            days.push(
                <div 
                    key={day} 
                    className={`day-circle ${logCount > 0 ? `active-${Math.min(logCount, 4)}` : 'inactive'}`}
                    title={`${dateString}: ${logCount > 0 ? 'Completed' : streakStarted ? 'freeze' : 'inactive'}`}
                >
                    {day}
                </div>
            );
        }

        return days;
    }

    return (
        <div className="heatmap-card">
            <div className="heatmap-header">
                <div className="icon">
                    <FontAwesomeIcon icon={faFireFlameCurved} size="lg" />
                </div>
                <div className="text">
                    <h2>Start your streak</h2>
                    <p>A little progress, every day</p>
                </div>
            </div>

            <div className="heatmap">
                <div className="weekdays">
                    <span>M</span>
                    <span>T</span>
                    <span>W</span>
                    <span>T</span>
                    <span>F</span>
                    <span>S</span>
                    <span>S</span>
                </div>
                <div className="days-grid">
                    {renderDays()}
                </div>
            </div>
        </div>
    );
}