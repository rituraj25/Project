 create table user
    -> (id int primary key auto_increment,
    -> email varchar (50),
    -> password varchar (50),
    -> resetpassword_sent_at datetime,
    -> signin_count int ,
    -> last_signin datetime,
    -> created_at datetime,
    -> updated_at datetime,
    -> name varchar(50),
    -> admin tinyint );

create table contact (
    -> id int primary key auto_increment ,
    -> name varchar (50),
    -> email varchar (50),
    -> address text (500),
    -> created_at datetime ,
    -> updated_at datetime,
    -> user_id int ,
    -> foreign key (user_id) references user (id));

create table cart(
    -> id int primary key auto_increment,
    -> user_id int ,
    -> sub_total int ,
    -> shipping_amount int ,
    -> foreign key (user_id) references user (id));

create table line_item(
    -> id int primary key auto_increment,
    -> cart_id int ,
    -> product_id int ,
    -> quantity int ,
    -> shiping_amount int ,
    -> sub_total int ,
    -> price int ,
    -> created_at datetime ,
    -> updated_at datetime ,
    -> foreign key (product_id) references product (id),
    -> foreign key (cart_id) references cart(id));