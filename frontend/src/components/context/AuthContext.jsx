import { createContext, useCallback, useContext, useEffect, useState } from "react";
import { api, tokenStore } from '../../api';

const AuthContext = createContext(null);

export function AuthProvider({children}) {
    const [user, setUser] = useState(null);
    const [isLoading, setIsLoading] = useState(true);

    const logout = useCallback(() => {
        tokenStore.clear();
        setUser(null);
    }, []);

    // If Time Expired -> Log out
    useEffect(() => {
        window.addEventListener("auth:expired", logout);
        return () => window.removeEventListener("auth:expired", logout);
    }, [logout]);

    // Checks if a token is saved and checks it with backend
    useEffect(() => {
        if (!tokenStore.get()) return;
        api("/api/auth/me")
            .then(user => setUser(user))
            .catch(() => tokenStore.clear())
            .finally(() => setIsLoading(false));
    }, []);

    async function login(email, password) {
        const data = await api("/api/auth/login", {method: "POST", body: { email, password } });
        tokenStore.set(data.token);
        setUser(data.user);
    }

    async function signup(name, email, password) {
        const data = await api("/api/auth/signup", {method: "POST", body: { name, email, password } });
        tokenStore.set(data.token);
        setUser(data.user);
    }

    return (
        <AuthContext.Provider value={{user, login, signup, logout, isLoading }}>
            {children}
        </AuthContext.Provider>
    )
}

export function useAuth() {
    const context = useContext(AuthContext);
    if (!context) throw new Error("useAuth must be provided inside <AuthProvider>");
    return context;
}