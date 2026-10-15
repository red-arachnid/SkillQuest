const BASE = "http://localhost:8080";   //! Change it later

// On Function to write all type of api
export async function apiCall(path, {method = "GET", body } = {}) {
    const headers = {};
    if (body) {
        headers["Content-Type"] = "application/json";
    }
    
    let response;
    try {
        response = await fetch(`${BASE}${path}`, {
            method,
            headers,
            body: body ? JSON.stringify(body) : undefined,
        });
    }
    catch {
        throw new Error("Cannot react the server...");
    }

    const data = await response.json().catch(() => null);

    if (!response.ok) {
        throw new Error(data?.message ?? "Something went wrong");
    }
    return data;
}