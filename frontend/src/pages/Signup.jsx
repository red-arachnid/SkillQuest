import '../styles/style.css';
import '../styles/login.css';
import Logo from '../../public/logo.svg?react';

export default function Signup() {
    return (
        <div className="login-page">
            <div className="site-info">
                <div className="brand">
                    <div className="brand-logo">
                        <Logo className="logo"/>
                    </div>

                    <div className="brand-name">
                        <span>Skill</span>
                        <span>Earn.</span>
                    </div>
                </div>

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

            <div className="form-container">
                <form action="">
                    <h2>Create your account</h2>
                    <p>It takes under a minute. Then pick your first skill.</p>
                    
                    <div className="input-field">
                    <label htmlFor="name">Name</label>
                    <input type="text" name="name" id="name"/>
                    </div>
                    
                    <div className="input-field">
                    <label htmlFor="email">Email</label>
                    <input type="email" name="email" id="email"/>
                    </div>
                    
                    <div className="input-field">
                    <label htmlFor="password">Password</label>
                    <input type="password" name="password" id="password"/>
                    </div>

                    <div className="input-field">
                    <label htmlFor="confirmPassword">Confirm Password</label>
                    <input type="password" name="confirmPassword" id="confirmPassword"/>
                    </div>
                    
                    <button>Sign up</button>
                    
                    <div className="foot">
                    <p>Already have an account? <a href="">Log in</a></p>
                    </div>
                </form>
            </div>
        </div>
    );
}