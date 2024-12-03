--  add tag data
INSERT INTO tag (tag_id, tag_name) VALUES (1, "TAG1");
INSERT INTO tag (tag_id, tag_name) VALUES (2, "TAG2");
INSERT INTO tag (tag_id, tag_name) VALUES (3, "TAG3");

--  add content data
insert into content(content_id) values (1);
insert into content(content_id) values (2);
insert into content(content_id) values (3);
insert into content(content_id) values (4);
insert into content(content_id) values (5);

--  add content_album data
insert into content_album(content_id, image_url, title, description)
values (1, '/content/v1/public/images/cat_1.jpeg', '떼껄룩1', '떼껄룩1');
insert into content_album(content_id, image_url, title, description)
values (2, '/content/v1/public/images/cat_2.jpeg', '떼껄룩2', '떼껄룩2');
insert into content_album(content_id, image_url, title, description)
values (3, '/content/v1/public/images/cat_3.jpeg', '떼껄룩3', '떼껄룩3');
insert into content_album(content_id, image_url, title, description)
values (4, '/content/v1/public/images/cat_4.jpeg', '떼껄룩4', '떼껄룩4');
insert into content_album(content_id, image_url, title, description)
values (5, '/content/v1/public/images/cat_5.jpeg', '떼껄룩5', '떼껄룩5');

--  add content_tag data
insert into content_tag(content_id, tag_id)
values (1, 1);
insert into content_tag(content_id, tag_id)
values (2, 1);
insert into content_tag(content_id, tag_id)
values (3, 2);
insert into content_tag(content_id, tag_id)
values (4, 3);
insert into content_tag(content_id, tag_id)
values (5, 3);
