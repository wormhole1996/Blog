create table blog.visit
(
  id     char(36)     not null
    primary key,
  url    varchar(100) not null,
  status int          not null,
  ip     varchar(50)  not null,
  agent  varchar(300),
  date   datetime     not null
);