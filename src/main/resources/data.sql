INSERT INTO visitor (timestamp, gender, language, age_Group, group_Size, in_Large_Group) VALUES (current_timestamp ,'female', 'Danish', '55+', 2, 0);
INSERT INTO visitor (timestamp, gender, language, age_Group, group_Size, in_Large_Group) VALUES (current_timestamp ,'male', 'English', '55+', 2, 0);

create table authorities (
                             username varchar(50) not null,
                             authority varchar(50) not null,
                             foreign key (username) references users (username)
);

insert into users(username, password, enabled)values('javainuse','$2y$12$yj3Htf.JgW7nYkxDKSu6Y.qh/qGvMn1/Ctvx.5qUgqszp2Ywd1SqK',true);
insert into authorities(username,authority)values('javainuse','ROLE_ADMIN');

insert into users(username, password, enabled)values('user','$2y$12$yj3Htf.JgW7nYkxDKSu6Y.qh/qGvMn1/Ctvx.5qUgqszp2Ywd1SqK',true);
insert into authorities(username,authority)values('user','ROLE_USER');

insert into users(username, password, enabled)values('admin','$2y$12$lffWhdg/baBunHQMGJp9H.OeYEiCRLe7ST0HyDw60DZbdr2yIRwb6',true);
insert into authorities(username,authority)values('admin','ROLE_ADMIN');