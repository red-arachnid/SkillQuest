

export default function ProfileIcon({ profileName }) {
    return (
        <div style={style}>{profileName}</div>
    );
}

const style = {
    display: "flex",
    "align-items": "center",
    "justify-content": "center",

    "background-color": "var(--ui4)",
    "width": "35px",
    "height": "35px",
    "border-radius": "50%",
    border: "2px solid var(--border2)",

    color: "var(--text-primary)",
    "font-family": "var(--font1)",
    "font-weight": "500",
    "font-size": "14px",
    cursor: "pointer",
}