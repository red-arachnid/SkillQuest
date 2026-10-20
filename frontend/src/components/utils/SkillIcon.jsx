import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import * as SolidIcons from "@fortawesome/free-solid-svg-icons";
import * as RegularIcons from "@fortawesome/free-regular-svg-icons";

const ICON_COLLECTION = {
    ...SolidIcons,
    ...RegularIcons
};

export default function SkillIcon({iconName, ...props }) {
    const icon = ICON_COLLECTION[iconName] || SolidIcons.faQuestion;
    return <FontAwesomeIcon icon={icon} {...props} />
}
