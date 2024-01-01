create database `content`;
create user `content` identified by 'welcome';
grant all privileges on `content`.* to `content`;
grant super on *.* to `content`;