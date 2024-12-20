create table if not exists paragraph(
    id int not null auto_increment,
    paragraph_name text not null,
    category text not null,
    author_id int not null,
    primary key(id)
);

-- add foreign key to user

create table if not exists user(
    id int not null auto_increment,
    first_name text not null,
    last_name text not null,
    nick_name text not null,
    role int not null,
    primary key(id)
);

create table if not exists credentials(
    id int not null auto_increment,
    login text not null,
    password text not null,
    email int not null,
    primary key(id)
);