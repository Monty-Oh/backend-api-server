create database `auth`;
create user `auth` identified by 'welcome';
grant all privileges on `auth`.* to `auth`;
grant super on *.* to `auth`;