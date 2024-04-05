import React, { useState, useMemo } from 'react';

function UseMemo() {
    const [number, setNumber] = useState(0);
    const [otherValue, setOtherValue] = useState(0);

    const longComputation = (num) => {
        console.log('long computation is running ...');
        let value = 0;
        for (let i = 0; i < 100000000; i++) {
            value += Math.random();
        }
        return num = value;
    }

    const computedValue = useMemo(() => {
        return longComputation(number);
    }, [number]);

    return (
        <div>
            <div>
                <button onClick={() => setNumber(number => number + 1)}>Increment Number ({number})</button>
            </div>
            <div>
                <button onClick={() => setOtherValue(otherValue => otherValue + 1)}>Increment Other Value({otherValue})</button>
            </div>
            <div>
                Computed value : {computedValue}
            </div>
        </div>
    );
}

export default UseMemo;