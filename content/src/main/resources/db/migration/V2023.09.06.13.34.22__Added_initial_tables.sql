USE `content`;

CREATE TABLE content (
    content_id      bigint unsigned auto_increment  not null    comment '컨텐츠 ID',

    PRIMARY KEY (content_id)
)
comment '컨텐츠';
