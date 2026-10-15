const EMAIL_RE = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

function checkEmail(email) {
    if (!email.trim()) return "Email is required";
    if (!EMAIL_RE.test(email.trim())) return "Enter a valid email";
    return null;
}

export function validateSignup({ name, email, password, confirm }) {
    const errors = {};
    if (!name.trim()) errors.name = "Name is required";
    else if (name.trim().length > 50) errors.name = "Name must be at most 50 characters";

    const emailErr = checkEmail(email);
    if (emailErr) errors.email = emailErr;

    if (!password) errors.password = "Password is required";
    else if (password.length < 8 || password.length > 72) {
        errors.password = "Password must be 8 to 72 characters";
    } 

    if (confirm !== password) errors.confirm = "Password do not match";
    return errors;
}