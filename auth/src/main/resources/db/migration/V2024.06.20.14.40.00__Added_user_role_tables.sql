CREATE TABLE user_roles
(
    user_no varchar(20) comment '사용자번호',
    role_id int(20) comment '역할 고유 ID',
    PRIMARY KEY (user_no, role_id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);

INSERT INTO user_roles(user_no, role_id)
VALUES ('0', 2);
