import React, { useState } from "react";

function Counter(props) {
    const [count, setCount] = useState(0);

    return (
        <div>
            <h1>{count}번 클릭했습니다.</h1>
            <button onClick={() => setCount(count + 1)}>클릭</button>
        </div>
    );
}

export default Counter;