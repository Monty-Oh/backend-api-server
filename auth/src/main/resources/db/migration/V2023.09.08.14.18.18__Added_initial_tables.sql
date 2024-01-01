USE `auth`;

CREATE TABLE auth (
    user_no         varchar(20)                     not null    comment '유저 번호',
    access_token    varchar(20)                     not null    comment '액세스 토큰',
    refresh_token   varchar(20)                     not null    comment '리프레시 토큰',

    PRIMARY KEY (user_no)
)
comment '인증';

CREATE UNIQUE INDEX ix01_auth ON auth (access_token);