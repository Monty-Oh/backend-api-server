USE `content`;

CREATE TABLE content (
    content_id      bigint unsigned auto_increment  not null    comment '콘텐츠 ID',
    content_no      varchar(20)                     not null    comment '콘텐츠 번호',

    PRIMARY KEY (content_id)
)
comment '콘텐츠';

CREATE UNIQUE INDEX ix01_content ON content (content_no);