import React from "react";

function book(props) {
    return (
        <div>
            <h1>{`이 책의 이름은 ${props.name}입니다.`}</h1>
            <h2>{`총 페이지 수는 ${props.numOfPage}페이지로 이루어져있습니다.`}</h2>
        </div>
    );
}

export default book;