create table if not exists paragraph(
    id int not null auto_increment,
    title text not null,
    body text not null,
    category_id int not null,
    created_date datetime not null,
    author_id int not null,
    primary key(id)
);

-- add foreign key to user

create table if not exists user(
    id int not null auto_increment,
    first_name text not null,
    last_name text not null,
    nick_name text not null,
    primary key(id)
);

create table if not exists credentials(
    id int not null auto_increment,
    login text not null,
    password text not null,
    email text not null,
    user_id int not null,
    primary key(id)
);

create table if not exists category(
    id int not null auto_increment,
    name text,
    primary key(id)
);

create table if not exists message(
    id int not null auto_increment,
    message text,
    sender_id int not null,
    conversation_id int not null,
    send_date datetime not null,
    primary key(id)
);

create table if not exists conversation(
    id int not null auto_increment,
    hash text not null,
    first_id int not null,
    second_id int not null,
    primary key(id)
);

insert into category (name) values ('Common'),('Goods'),('Ads');