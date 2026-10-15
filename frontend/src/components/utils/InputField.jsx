

export default function InputField({ id, label, error, ...inputProps }) {
    return (
        <div className="input-field">
            <label htmlFor={id}>{label}</label>
            <input 
                id={id}
                name={id}
                className={error ? "input-error" : ""}
                aria-invalid={Boolean(error)}
                aria-describedby={Boolean(error) ? `${id}-err` : undefined}
                {...inputProps}
            />
            {Boolean(error) && <p id={`${id}-err`} className="field-error">{error}</p>}
        </div>
    );
}