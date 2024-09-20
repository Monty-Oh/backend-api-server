-- init tag table
CREATE TABLE tag
(
    tag_id   bigint unsigned auto_increment NOT NULL comment '태그 ID',
    tag_name varchar(100)                   NOT NULL comment '태그 이름',

    PRIMARY KEY (tag_id),
    UNIQUE (tag_name)
) comment '태그 정보';


-- init content_tag table
CREATE TABLE content_tag
(
    content_no varchar(20)     NOT NULL comment '콘텐츠 번호(외부키)',
    tag_id     bigint unsigned NOT NULL comment '태그 ID(외부키)',

    PRIMARY KEY (content_no, tag_id),
    FOREIGN KEY (content_no) REFERENCES content (content_no) ON DELETE CASCADE,
    FOREIGN KEY (tag_id) REFERENCES tag (tag_id) ON DELETE CASCADE
) comment 'content - tag 연결 테이블';