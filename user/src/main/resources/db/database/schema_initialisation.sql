create database `user`;
create user `user` identified by 'welcome';
grant all privileges on `user`.* to `user`;
grant super on *.* to `user`;