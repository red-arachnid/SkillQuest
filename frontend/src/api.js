const BASE = "http://localhost:8080";   //! Change it later
const TOKEN_KEY_NAME = "skillquest_token";

export const tokenStore = {
    get: () => localStorage.getItem(TOKEN_KEY_NAME),
    set: (t) => localStorage.setItem(TOKEN_KEY_NAME, t),
    clear: () => localStorage.removeItem(TOKEN_KEY_NAME),
}

export class ApiError extends Error {
    constructor(message, status) {
        super(message);
        this.status = status;
    }
}

// On Function to write all type of api
export async function api(path, {method = "GET", body } = {}) {
    const headers = {};
    headers["Content-Type"] = "application/json";
    
    const token = tokenStore.get();
    if (token) headers.Authorization = `Bearer ${token}`;

    const options = {
        method,
        headers,
    };

    if (method !== "GET" && method !== 'HEAD' && body) {
        options.body = JSON.stringify(body);
    }
    
    let response;
    try {
        response = await fetch(`${BASE}${path}`, options);
    }
    catch (e) {
        throw new ApiError("Cannot reach the server. " + e, 0);
    }

    const data = await response.json().catch(() => null);

    if (!response.ok) {
        if (response.status === 401 && !path.startsWith("/api/auth/login")) {
            window.dispatchEvent(new Event("auth:expired"));
        }
        throw new ApiError(data?.message ?? "Something went wrong", response.status);
    }
    return data;
}