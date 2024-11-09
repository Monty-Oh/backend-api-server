CREATE TABLE content_album
(
    content_id  bigint unsigned  NOT NULL    comment '컨텐츠 ID',
    image_url   varchar(255) NOT NULL comment '이미지 경로',
    title       varchar(100) NOT NULL comment '컨텐츠 이름',
    description text         NOT NULL comment '컨텐츠 설명',

    PRIMARY KEY (content_id),
    FOREIGN KEY (content_id) REFERENCES content (content_id) ON DELETE CASCADE
) comment '앨범 컨텐츠';