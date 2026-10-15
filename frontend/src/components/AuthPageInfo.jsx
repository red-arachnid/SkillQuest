import '../styles/auth.css'
import Brand from '../components/Brand';

export default function AuthPageInfo() {
    return (
        <div className="site-info">
            <Brand />

            <div className="about">
                <h1>Stop wondering where to start.</h1>
                <p>Tell us what you want to learn. Get a day-by-day plan, a checklist and the right resources.</p>

                <div className="famous-skills">
                    <div className="skill">Karate</div>
                    <div className="skill">Chess</div>
                    <div className="skill">Guitar</div>
                    <div className="skill">Video Editing</div>
                </div>
            </div>
        </div>
    );
}