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
    section_number      integer     not null,
    start_measuring_day integer     not null,
    stop_measuring_day  integer     not null,
    created_at          timestamp   not null,
    last_modified_at    timestamp,
    street_id           integer     not null
        constraint fk_street_id
            references street
);

INSERT INTO dwelling (number, section_number, last_modified_at, start_measuring_day, stop_measuring_day,
                      created_at,
                      street_id)
VALUES ('1/12', 2, now(), 10, 19, now(), 1);
INSERT INTO dwelling (number, section_number, last_modified_at, start_measuring_day, stop_measuring_day,
                      created_at,
                      street_id)
VALUES ('13', 12, now(), 10, 19, now(), 2);
INSERT INTO dwelling (number, section_number, last_modified_at, start_measuring_day, stop_measuring_day,
                      created_at,
                      street_id)
VALUES ('13', 6, now(), 10, 19, now(), 3);

create table section
(
    id           integer generated by default as identity
        primary key,
    number       integer   not null,
    created_at   timestamp not null,
    floor_number integer   not null,
    dwelling_id  integer   not null
        constraint fk_dwelling_id
            references dwelling
);

INSERT INTO section (number, created_at, floor_number, dwelling_id)
VALUES (1, now(), 25, 1);
INSERT INTO section (number, created_at, floor_number, dwelling_id)
VALUES (2, now(), 25, 1);

INSERT INTO section (number, created_at, floor_number, dwelling_id)
VALUES (1, now(), 9, 2);
INSERT INTO section (number, created_at, floor_number, dwelling_id)
VALUES (2, now(), 9, 2);
INSERT INTO section (number, created_at, floor_number, dwelling_id)
VALUES (3, now(), 9, 2);
INSERT INTO section (number, created_at, floor_number, dwelling_id)
VALUES (4, now(), 9, 2);
INSERT INTO section (number, created_at, floor_number, dwelling_id)
VALUES (5, now(), 9, 2);
INSERT INTO section (number, created_at, floor_number, dwelling_id)
VALUES (6, now(), 9, 2);
INSERT INTO section (number, created_at, floor_number, dwelling_id)
VALUES (7, now(), 9, 2);
INSERT INTO section (number, created_at, floor_number, dwelling_id)
VALUES (7, now(), 9, 2);
INSERT INTO section (number, created_at, floor_number, dwelling_id)
VALUES (8, now(), 9, 2);
INSERT INTO section (number, created_at, floor_number, dwelling_id)
VALUES (9, now(), 9, 2);
INSERT INTO section (number, created_at, floor_number, dwelling_id)
VALUES (10, now(), 9, 2);

INSERT INTO section (number, created_at, floor_number, dwelling_id)
VALUES (1, now(), 5, 3);
INSERT INTO section (number, created_at, floor_number, dwelling_id)
VALUES (2, now(), 5, 3);
INSERT INTO section (number, created_at, floor_number, dwelling_id)
VALUES (3, now(), 5, 3);
INSERT INTO section (number, created_at, floor_number, dwelling_id)
VALUES (4, now(), 5, 3);
INSERT INTO section (number, created_at, floor_number, dwelling_id)
VALUES (5, now(), 5, 3);
INSERT INTO section (number, created_at, floor_number, dwelling_id)
VALUES (6, now(), 5, 3);

create table floor
(
    id               integer generated by default as identity
        primary key,
    number           integer   not null,
    apartment_number integer   not null,
    created_at       timestamp not null,
    section_id       integer   not null
        constraint fk_section_id
            references section
);

INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (1, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (2, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (3, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (4, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (5, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (6, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (7, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (8, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (9, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (10, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (11, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (12, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (13, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (14, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (15, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (16, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (17, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (18, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (19, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (20, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (21, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (22, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (23, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (24, 6, now(), 2);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (25, 6, now(), 2);

INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (1, 4, now(), 7);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (2, 4, now(), 7);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (3, 4, now(), 7);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (4, 4, now(), 7);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (5, 4, now(), 7);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (6, 4, now(), 7);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (7, 4, now(), 7);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (8, 4, now(), 7);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (9, 4, now(), 7);

INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (1, 3, now(), 15);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (2, 3, now(), 15);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (3, 3, now(), 15);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (4, 3, now(), 15);
INSERT INTO floor (number, apartment_number, created_at, section_id)
VALUES (5, 3, now(), 15);

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
    dwelling_id      integer   not null
        constraint fk_dwelling_id
            references dwelling,
    floor_id         integer   not null
        constraint fk_floor_id
            references floor
);

INSERT INTO apartment (number, type, owner, phone, created_at, last_modified_at, dwelling_id, floor_id)
VALUES (124, 'TWO_ROOM_APARTMENT', 'Кривцов Евгений Алексеевич', '', now(), now(), 1, 11);

INSERT INTO apartment (number, type, owner, phone, created_at, last_modified_at, dwelling_id, floor_id)
VALUES (163, 'TWO_ROOM_APARTMENT', 'Кривцов Алексей Иванович', '', now(), now(), 2, 29);

INSERT INTO apartment (number, type, owner, phone, created_at, last_modified_at, dwelling_id, floor_id)
VALUES (23, 'TWO_ROOM_APARTMENT', 'Кривцова Марина Владимировна', '', now(), now(), 3, 38);

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
    dwelling_id      integer          not null
        constraint fk_dwelling_id
            references dwelling,
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