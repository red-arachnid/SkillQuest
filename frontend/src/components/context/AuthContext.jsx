import { createContext, useCallback, useContext, useState } from "react";
import { apiCall } from '../../api';

const AuthContext = createContext(null);

export function AuthProvider({children}) {
    const [user, setUser] = useState(null);

    const logout = useCallback(() => {
        setUser(null);
    }, []);

    async function login(email, password) {
        const data = await apiCall("/api/auth/login", {method: "POST", body: { email, password } });
        setUser(data.name);
    }

    async function signup(name, email, password) {
        const data = await apiCall("/api/auth/signup", {method: "POST", body: { name, email, password } });
        setUser(data.name);
        console.log(data.name);
    }

    return (
        <AuthContext.Provider value={{user, login, signup}}>
            {children}
        </AuthContext.Provider>
    )
}

export function useAuth() {
    const context = useContext(AuthContext);
    if (!context) throw new Error("useAuth must be provided inside <AuthProvider>");
    return context;
}