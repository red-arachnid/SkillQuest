import '../../styles/pageHeading.css';
import {faCalendar} from '@fortawesome/free-regular-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

export default function PageHeading({
    heading = "Ready, set, level up.", 
    subHeading = "Hey! pick a skill, Let the adventure begin"
}) {
    const now = new Date();
    const date = String(now.getDate()).padStart(2, '0');
    const day = now.toLocaleDateString('en-US', { weekday: 'long' });
    const month = now.toLocaleDateString('en-US', { month: 'long' });

    return (
        <div className="heading">
            <div className="heading-left">
                <h1>{heading}</h1>
                <p>{subHeading}</p>
            </div>

            <div className="heading-right">
                <FontAwesomeIcon icon={faCalendar} />
                <p>{day}, {date} {month}</p>
            </div>
        </div>
    );
}