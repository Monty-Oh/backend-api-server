CREATE TABLE roles
(
    id          int(20) not null AUTO_INCREMENT comment '역할 고유 ID',
    name        varchar(20) not null comment '역할 이름',
    description varchar(20) not null comment '역할 설명',
    PRIMARY KEY (id)
) comment '역할';

CREATE UNIQUE INDEX ix01_role ON roles (name);

INSERT INTO roles(name, description)
VALUES ('ROLE_GUEST', '방문자');
INSERT INTO roles(name, description)
VALUES ('ROLE_MASTER', '마스터');