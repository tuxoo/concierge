CREATE SCHEMA IF NOT EXISTS concierge;

create table email
(
    id      integer generated by default as identity
        primary key,
    email   varchar(255) not null,
    address varchar(255) not null,
    user_id integer      not null
);

create table "user"
(
    id            integer generated by default as identity
        primary key,
    name          varchar(255) not null,
    login         varchar(255) not null
        unique,
    password_hash varchar(255) not null,
    registered_at timestamp    not null,
    visited_at    timestamp    not null,
    role          varchar(255) default 'TENANT':: character varying
);

INSERT INTO "user" (name, login, password_hash, registered_at, visited_at)
VALUES ('admin', 'admin', '', now(), now());

create table street
(
    id               integer generated by default as identity
        primary key,
    name             varchar(255) not null
        unique,
    city             varchar(255) not null,
    created_at       timestamp    not null,
    last_modified_at timestamp    not null

);

INSERT INTO street (name, city, created_at, last_modified_at)
VALUES ('Переверткина', 'VORONEZH', now(), now());
INSERT INTO street (name, city, created_at, last_modified_at)
VALUES ('Баррикадная', 'VORONEZH', now(), now());
INSERT INTO street (name, city, created_at, last_modified_at)
VALUES ('Туполева', 'VORONEZH', now(), now());

create table dwelling
(
    id                  integer generated by default as identity
        primary key,
    number              varchar(15) not null,
    floor_number        integer     not null,
    section_number      integer     not null,
    last_modified_at    timestamp,
    start_measuring_day integer     not null,
    stop_measuring_day  integer     not null,
    created_at          timestamp   not null,
    street_id           integer     not null
        constraint fk_street_id
            references street
);

INSERT INTO dwelling (number, floor_number, section_number, last_modified_at, start_measuring_day, stop_measuring_day,
                      created_at,
                      street_id)
VALUES ('1/12', 25, 2, now(), 10, 19, now(), 1);
INSERT INTO dwelling (number, floor_number, section_number, last_modified_at, start_measuring_day, stop_measuring_day,
                      created_at,
                      street_id)
VALUES ('13', 9, 12, now(), 10, 19, now(), 2);
INSERT INTO dwelling (number, floor_number, section_number, last_modified_at, start_measuring_day, stop_measuring_day,
                      created_at,
                      street_id)
VALUES ('13', 5, 6, now(), 10, 19, now(), 3);

create table floor
(
    id               integer generated by default as identity
        primary key,
    number           integer   not null,
    section          integer   not null,
    apartment_number integer   not null,
    created_at       timestamp not null,
    last_modified_at timestamp not null,
    dwelling_id      integer   not null
        constraint fk_dwelling_id
            references dwelling
);

INSERT INTO floor (number, section, apartment_number, created_at, last_modified_at, dwelling_id)
VALUES (11, 2, 6, now(), now(), 1);

INSERT INTO floor (number, section, apartment_number, created_at, last_modified_at, dwelling_id)
VALUES (9, 5, 4, now(), now(), 2);

INSERT INTO floor (number, section, apartment_number, created_at, last_modified_at, dwelling_id)
VALUES (4, 2, 3, now(), now(), 3);

create table apartment
(
    id               integer generated by default as identity
        primary key,
    number           integer   not null,
    type             varchar(255),
    owner            varchar(255),
    phone            varchar(15),
    created_at       timestamp not null,
    last_modified_at timestamp not null,
    floor_id         integer   not null
        constraint fk_floor_id
            references floor
);

INSERT INTO apartment (number, type, owner, phone, created_at, last_modified_at, floor_id)
VALUES (124, 'TWO_ROOM_APARTMENT', 'Кривцов Евгений Алексеевич', '', now(), now(), 1);

INSERT INTO apartment (number, type, owner, phone, created_at, last_modified_at, floor_id)
VALUES (163, 'TWO_ROOM_APARTMENT', 'Кривцов Алексей Иванович', '', now(), now(), 1);

INSERT INTO apartment (number, type, owner, phone, created_at, last_modified_at, floor_id)
VALUES (23, 'TWO_ROOM_APARTMENT', 'Кривцова Марина Владимировна', '', now(), now(), 1);

create table year
(
    id integer not null
        primary key
);

INSERT INTO year (id)
VALUES (2022);
INSERT INTO year (id)
VALUES (2023);
INSERT INTO year (id)
VALUES (2024);

create table month
(
    id         integer     not null
        primary key,
    name       varchar(15) not null,
    short_name varchar(3)  not null
);

INSERT INTO month (id, name, short_name)
VALUES (1, 'Январь', 'Jan');
INSERT INTO month (id, name, short_name)
VALUES (2, 'Февраль', 'Feb');
INSERT INTO month (id, name, short_name)
VALUES (3, 'Март', 'Mar');
INSERT INTO month (id, name, short_name)
VALUES (4, 'Апрель', 'Apr');
INSERT INTO month (id, name, short_name)
VALUES (5, 'Май', 'May');
INSERT INTO month (id, name, short_name)
VALUES (6, 'Июнь', 'Jun');
INSERT INTO month (id, name, short_name)
VALUES (7, 'Июль', 'Jul');
INSERT INTO month (id, name, short_name)
VALUES (8, 'Август', 'Aug');
INSERT INTO month (id, name, short_name)
VALUES (9, 'Сентябрь', 'Sep');
INSERT INTO month (id, name, short_name)
VALUES (10, 'Октябрь', 'Oct');
INSERT INTO month (id, name, short_name)
VALUES (11, 'Ноябрь', 'Nov');
INSERT INTO month (id, name, short_name)
VALUES (12, 'Декабрь', 'Dec');

create table heating
(
    id               integer generated by default as identity
        primary key,
    measure          double precision not null,
    created_at       timestamp        not null,
    last_modified_at timestamp        not null,
    apartment_id     integer          not null
        constraint fk_apartment_id
            references apartment,
    month_id         integer          not null
        constraint fk_month_id
            references month,
    year_id          integer          not null
        constraint fk_year_id
            references year
);