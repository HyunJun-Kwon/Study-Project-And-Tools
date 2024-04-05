import React from "react";
import Comment from "./Comment";

const comments = [
    {
        name: "홍길동",
        comment: "안녕하세요 반가워요 !",
    },
    {
        name: "권현준",
        comment: "리액트 재밌어요",
    },
    {
        name: "김민재",
        comment: "잘 지내고 있어요 !",
    }
]

function CommentList(props) {
    return (
        <div>
            {comments.map((comm) => {
                return (
                    <Comment name={comm.name} comment={comm.comment} />
                );
            })}
        </div>
    )
}

export default CommentList;