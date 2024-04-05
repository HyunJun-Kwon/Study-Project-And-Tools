import React from "react";
import Notification from "./Notification";

const reservedNotifications = [
    {
        message: "안녕하세요, 반가워요 !",
    },
    {
        message: "또 만났군요 !",
    },
    {
        message: "다음에 또 봐요 !",
    },
]

var timer;

class NotificationList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            notifications: [],
        };
    };

    componentDidMount() {
        const { notifications } = this.state;
        timer = setInterval(() => {
            if (notifications.length < reservedNotifications.length) {
                const index = notifications.length;
                notifications.push(reservedNotifications[index]);
                this.setState({
                    notifications: notifications, //이렇게 state가 update 될때 마다 render함수를 call한다.
                });

            } else {
                clearInterval(timer); //timer, 즉 3초마다 반복되는 것을 취소한다.
            }
        }, 3000); //처음 3초가 지난 후에 {}가 실행된다.
    } // end of componentDidMount()

    render() {
        return (
            <div>
                {this.state.notifications.map((notification) => {
                    return <Notification message={notification.message} />;
                })}
            </div>
        );
    } // end of render()
}

export default NotificationList;