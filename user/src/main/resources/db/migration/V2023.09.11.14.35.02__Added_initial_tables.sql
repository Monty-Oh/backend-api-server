USE `user`;

CREATE TABLE users
(
    id  int(20) not null AUTO_INCREMENT not null comment '사용자고유ID',
    no  varchar(20) comment '사용자번호',
    login_id varchar(20) comment '사용자로그인ID',
    PRIMARY KEY (id)
) comment '유저';

CREATE UNIQUE INDEX ix01_user ON users (no);
CREATE UNIQUE INDEX ix02_user ON users (login_id);