CREATE TABLE content_album
(
    content_id  bigint unsigned  NOT NULL    comment '컨텐츠 ID',
    album_no    bigint unsigned auto_increment  NOT NULL    comment '앨범 번호',
    image_url   varchar(255) NOT NULL comment '이미지 경로',
    title       varchar(100) NOT NULL comment '컨텐츠 이름',
    description text         NOT NULL comment '컨텐츠 설명',

    PRIMARY KEY (album_no),
    FOREIGN KEY (content_id) REFERENCES content (content_id) ON DELETE CASCADE
) comment '앨범 컨텐츠';