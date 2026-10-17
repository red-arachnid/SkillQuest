import '../../styles/searchbar.css';
import { faMagnifyingGlass } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

export default function Searchbar({ onClick }) {
    return (
        <div className="search-bar">
            <FontAwesomeIcon icon={faMagnifyingGlass} size="md" className="icon"/>
            <input 
                type="text" 
                name="skillSearch" 
                id="skillSearch" 
                placeholder="Search anything you want to learn..."
            />
            <button onClick={onClick}>Find my skill →</button>
        </div>
    );
}