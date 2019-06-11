create table merchant (
    id bigint not null auto_increment,
    active boolean not null,
    functionalities varchar(255),
    country varchar(255) not null,
    currency varchar(3),
    default_message varchar(255),
    max_amount decimal(19,2) not null,
    merchant_description varchar(255),
    merchant_name varchar(255),
    merchant_note varchar(255),
    merchant_picture varchar(255),
    metadata text,
    min_amount decimal(19,2) not null,
    shopping_option varchar(255) not null,
    website varchar(255),
    partner_fk bigint not null,
    type_fk bigint not null,
    primary key (id)
) engine=InnoDB;

create table merchant_address (
    id bigint not null auto_increment,
    city varchar(255),
    country varchar(255),
    lattitude varchar(255),
    longitude varchar(255),
    province varchar(255),
    street varchar(255),
    zipcode varchar(255),
    merchant_fk bigint not null,
    primary key (id)
) engine=InnoDB;

create table merchant_denomination (
    id bigint not null auto_increment,
    amount decimal(19,2),
    merchant_fk bigint,
    primary key (id)
) engine=InnoDB;

create table merchant_partner (
    id bigint not null auto_increment,
    country varchar(255) not null,
    currency varchar(3),
    merchant_partner_name varchar(255),
    metadata text,
    primary key (id)
) engine=InnoDB;

create table merchant_type (
    id bigint not null auto_increment,
    merchant_type_name varchar(255),
    merchant_type_picture varchar(255),
    primary key (id)
) engine=InnoDB;

alter table merchant 
    add constraint FKdjtillek0vnqfwvnhwqthfxmo 
    foreign key (partner_fk) 
    references merchant_partner (id);

alter table merchant 
    add constraint FK25e2koty0jr0ctspfw9e8ar6n 
    foreign key (type_fk) 
    references merchant_type (id);

alter table merchant_address 
    add constraint FK2h29afjrcua5y0xuyb71m0r1 
    foreign key (merchant_fk) 
    references merchant (id);

alter table merchant_denomination 
    add constraint FKlqyff5p0yp325240guab82ve8 
    foreign key (merchant_fk) 
    references merchant (id);