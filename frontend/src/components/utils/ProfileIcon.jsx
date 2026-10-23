

export default function ProfileIcon({ profileName }) {
    return (
        <div style={style}>{profileName}</div>
    );
}

const style = {
    display: "flex",
    alignItems: "center",
    justifyContent: "center",

    backgroundColor: "var(--ui4)",
    width: "35px",
    height: "35px",
    borderRadius: "50%",
    border: "2px solid var(--border2)",

    color: "var(--text-primary)",
    fontFamily: "var(--font1)",
    fontWeight: "500",
    fontSize: "14px",
    cursor: "pointer",
    pointerEvent: "none"
}