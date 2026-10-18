import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import * as SolidIcons from "@fortawesome/free-solid-svg-icons";
import * as RegularIcons from "@fortawesome/free-regular-svg-icons";

const ICON_COLLECTION = {
    ...SolidIcons,
    ...RegularIcons
};

export default function SkillIcon({iconName, ...props }) {
    const icon = ICON_COLLECTION[iconName] || SolidIcons.faQuestion;
    return <FontAwesomeIcon icon={icon} style={style} {...props} />
}


const style = {
    backgroundColor: "var(--ui6)",
    border: "2px solid var(--border1)",
    color: "var(--ui7)",
    borderRadius: "8px",
    padding: "8px 6px",
    boxShadow: "0px 1px 2px rgba(0,0,0,0.1)",
    transform: "rotate(-3deg)"
}