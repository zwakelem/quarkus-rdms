create sequence hibernate_sequence start 1 increment 1;

    create table Book (
       isbn varchar(15),
        language varchar(20),
        no_of_pages int4,
        publication_date date,
        id int8 not null,
        publisher_fk int8,
        primary key (id)
    );

    create table CD (
       genre varchar(100),
        music_company varchar(255),
        id int8 not null,
        primary key (id)
    );

    create table t_artist (
       id int8 not null,
        bio varchar(3000),
        created_date timestamp not null,
        name varchar(100) not null,
        primary key (id)
    );

    create table t_customer (
       id int8 not null,
        createdDate timestamp,
        email varchar(255),
        firstName varchar(255),
        lastName varchar(255),
        primary key (id)
    );

    create table t_items (
       id int8 not null,
        created_date timestamp not null,
        description varchar(3000),
        price numeric(19, 2) not null,
        title varchar(100) not null,
        artist_fk int8,
        primary key (id)
    );

    create table t_publisher (
       id int8 not null,
        created_date timestamp not null,
        name varchar(50) not null,
        primary key (id)
    );

    create table t_purchase_order_lines (
       id int8 not null,
        created_date timestamp not null,
        quantity int4 not null,
        item_fk int8,
        purchase_order_fk int8,
        primary key (id)
    );

    create table t_purchase_orders (
       id int8 not null,
        created_date timestamp not null,
        purchase_order_date date not null,
        customer_fk int8,
        primary key (id)
    );

    create table t_tracks (
       id int8 not null,
        created_date timestamp not null,
        duration int8 not null,
        title varchar(255) not null,
        cd_fk int8,
        primary key (id)
    );

    alter table if exists Book 
       add constraint FKao8ci9x8ys3c5l0l04pbvrp8a 
       foreign key (publisher_fk) 
       references t_publisher;

    alter table if exists Book 
       add constraint FKrc4aujt4u7vihi7kovrbbtxsv 
       foreign key (id) 
       references t_items;

    alter table if exists CD 
       add constraint FKaytv0uvt7n00ea6i2dnw4o78v 
       foreign key (id) 
       references t_items;

    alter table if exists t_items 
       add constraint FKeyhihm5a9e0ivj78rpgqlbs34 
       foreign key (artist_fk) 
       references t_artist;

    alter table if exists t_purchase_order_lines 
       add constraint FKf51l5n972qc282ubbv97c1kfa 
       foreign key (item_fk) 
       references t_items;

    alter table if exists t_purchase_order_lines 
       add constraint FKbjsagtstxdmdm55cxqvbxkaji 
       foreign key (purchase_order_fk) 
       references t_purchase_orders;

    alter table if exists t_purchase_orders 
       add constraint FKi4urn9k534rm77g6o2bjl6r5v 
       foreign key (customer_fk) 
       references t_customer;

    alter table if exists t_tracks 
       add constraint FKd2cxlowirxhlmf3s87rc8jcvf 
       foreign key (cd_fk) 
       references CD;
