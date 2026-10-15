import { useState } from 'react';
import { Link } from 'react-router-dom';
import AuthPageInfo from '../components/AuthPageInfo';
import InputField from '../components/utils/InputField';

export default function Login() {
    const [form, setForm] = useState({email: "", password: ""});
    const [submitting, setSubmitting] = useState(false);

    function onSubmit(e) {
        e.preventDefault();

        setSubmitting(true);
    }

    function onChange(e) {
        setForm({ ...form, [e.target.name]: e.target.value });
    }

    return (
        <div className="auth-page">
            <AuthPageInfo />

            <div className="form-container">
                <form onSubmit={onSubmit} noValidate>
                    <h2>Welcome back</h2>
                    <p>Log in to continue your learning.</p>

                    {/* <div className="error">Invalid email or password</div> */}
                    
                    <InputField id="email" label="Email" error={errors.email} type="email" autoComplete="email" value={form.email} onChange={onChange}/>

                    <InputField id="password" label="Password" error={errors.password} type="password" autoComplete="current-password" value={form.password} onChange={onChange}/>

                    <button type="submit" disabled={submitting}>
                        {submitting ? "Logging in" : "Log in" }
                    </button>

                    <div className="foot">
                        <p>New here? <Link to="/signup">Create an account</Link></p>
                    </div>
                </form>
            </div>
        </div>
    );
}