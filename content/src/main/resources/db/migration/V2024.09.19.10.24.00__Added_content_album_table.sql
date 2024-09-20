CREATE TABLE content_album
(
    content_no          varchar(20)  NOT NULL comment '콘텐츠 번호(외부키)',
    image_path          varchar(255) NOT NULL comment '이미지 경로',
    content_name        varchar(100) NOT NULL comment '콘텐츠 이름',
    content_description text         NOT NULL comment '콘텐츠 설명',

    PRIMARY KEY (content_no),
    FOREIGN KEY (content_no) REFERENCES content (content_no) ON DELETE CASCADE
) comment '앨범 컨텐츠';