import Logo from '../../public/logo.svg?react';
import '../styles/brand.css'

export default function Brand({ size = 'md', className = ''}) {
    return (
        <div className={`brand brand--${size} ${className}`.trim()}>
            <div className="brand-logo">
                <Logo className="logo" />
            </div>

            <div className="brand-name">
                <span>Skill</span>
                <span>Quest.</span>
            </div>
        </div>
    );
}

