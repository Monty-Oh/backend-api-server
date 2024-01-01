USE `user`;

CREATE TABLE users
(
    user_id  varchar(20) not null comment '사용자고유ID',
    user_no  varchar(20) comment '사용자번호',
    login_id varchar(20) comment '사용자로그인ID',
    PRIMARY KEY (user_id)
) comment '유저';

CREATE UNIQUE INDEX ix01_user ON users (user_no);
CREATE UNIQUE INDEX ix02_user ON users (login_id);