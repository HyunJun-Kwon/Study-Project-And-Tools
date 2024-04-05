import React from "react";

const styles = {
    wrapper: {
        margin: 8,
        padding: 8,
        display: "flex",
        flexDirection: "row",
        border: "1px solid gray",
        borderRadius: 16,
    },
    messageText: {
        color: "black",
        fontSize: 16,
    },
};

class Notification extends React.Component {
    constructor(props) {
        super(props); // ES6에서 파생된 클래스에서 생성자를 정의할 때는 super()호출을 통해 부모 클래스의 생성자를 먼저 호출해야 한다.
        this.state = {}; //state에는 아무런 데이터도 가지고 있지 않다.
    }

    render() {
        return (
            <div style={styles.wrapper}>
                <span style={styles.messageText}>{this.props.message}</span>
            </div>
        );
    }
}

export default Notification;