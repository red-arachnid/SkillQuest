import { Link } from 'react-router-dom';
import AuthPageInfo from '../components/AuthPageInfo';
import { useAuth } from '../components/context/AuthContext';
import { useState } from 'react';
import { validateSignup } from '../validation';
import InputField from '../components/utils/InputField';

export default function Signup() {
    const { signup } = useAuth();
    
    const [form, setForm] = useState({ name: "", email: "", password: "", confirm: "" });
    const [errors, setErrors] = useState({});
    const [serverError, setServerError] = useState("");
    const [submitting, setSubmitting] = useState(false);

    async function onSubmit(e) {
        e.preventDefault();
        setServerError("");
        
        const errorFound = validateSignup(form);
        setErrors(errorFound);
        if (Object.keys(errorFound).length > 0) return;  //Return if any error was found

        //No frontend erros -> send to backend
        setSubmitting(true);
        try {
            await signup(form.name, form.email, form.password);
        }
        catch (e) {
            setServerError(e.message);
            setErrors(e.fieldError);
        }
        finally {
            setSubmitting(false);
        }
    }

    function onChange(e) {
        setForm({ ...form, [e.target.name]: e.target.value });
    }

    return (
        <div className="auth-page">
            <AuthPageInfo />

            <div className="form-container">
                <form onSubmit={onSubmit} noValidate>
                    <h2>Create your account</h2>
                    <p>It takes under a minute. Then pick your first skill.</p>
                    
                    { serverError && <div className="error">{serverError}</div> }

                    <InputField id="name" label="Name" error={errors.name} type="text" autoComplete="name" value={form.name} onChange={onChange}/>
                    
                    <InputField id="email" label="Email" error={errors.email} type="email" autoComplete="email" value={form.email} onChange={onChange}/>
                    
                    <InputField id="password" label="Password" error={errors.password} type="password" autoComplete="new-password" value={form.password} onChange={onChange}/>

                    <InputField id="confirm" label="Confirm Password" error={errors.confirm} type="password" autoComplete="new-password" value={form.confirm} onChange={onChange}/>
                    
                    <button type="submit" disabled={submitting}>
                        {submitting ? "Creating account" : "Create Account" }
                    </button>
                    
                    <div className="foot">
                        <p>Already have an account? <Link to="/login">Log In</Link></p>
                    </div>
                </form>
            </div>
        </div>
    );
}