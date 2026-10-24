import '../../styles/searchbar.css';
import { faMagnifyingGlass } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { useRef } from 'react';

export default function Searchbar({ placeholder, onClick }) {
    const inputField = useRef(null);

    return (
        <div className="search-bar">
            <FontAwesomeIcon icon={faMagnifyingGlass} size="md" className="icon"/>
            <input 
                ref={inputField}
                type="text" 
                name="skillSearch" 
                id="skillSearch" 
                placeholder={ placeholder ?? "Search anything you want to learn..."}
            />
            <button onClick={() => {onClick(inputField.current?.value)}} >Find my skill →</button>
        </div>
    );
}