

export default function InputField({ id, label, error, ...inputProps }) {
    return (
        <div className="input-field">
            <label htmlFor={id}>{label}</label>
            <input 
                id={id}
                name={id}
                className={error ? "input-error" : ""}
                aria-invalid={!!error}
                aria-describedby={error ? `${id}-err` : undefined}
                {...inputProps}
            />
            {error && <p id={`${id}-err`} className="field-error">{error}</p>}
        </div>
    );
}