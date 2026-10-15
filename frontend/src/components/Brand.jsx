import Logo from '../../public/logo.svg?react';
import '../styles/brand.css'

export default function Brand() {
    return (
        <div className="brand">
            <div className="brand-logo">
                <Logo className="logo"/>
            </div>

            <div className="brand-name">
                <span>Skill</span>
                <span>Earn.</span>
            </div>
        </div>
    );
}

