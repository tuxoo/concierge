-- user

INSERT INTO "user" (name, login, password_hash, registered_at, visited_at)
VALUES ('admin', 'admin', '', now(), now());

-- email

INSERT INTO email (address, is_active, user_id)
VALUES ('idler.email@yandex.ru', true, 1);

-- street

INSERT INTO street (name, city, created_at, last_modified_at)
VALUES ('Переверткина', 'VORONEZH', now(), now());
INSERT INTO street (name, city, created_at, last_modified_at)
VALUES ('Баррикадная', 'VORONEZH', now(), now());
INSERT INTO street (name, city, created_at, last_modified_at)
VALUES ('Туполева', 'VORONEZH', now(), now());

-- dwelling

INSERT INTO dwelling (number, last_modified_at, start_measuring_day, stop_measuring_day,
                      created_at,
                      street_id)
VALUES ('1/12', now(), 10, 19, now(), 1);
INSERT INTO dwelling (number, last_modified_at, start_measuring_day, stop_measuring_day,
                      created_at,
                      street_id)
VALUES ('13', now(), 10, 19, now(), 2);
INSERT INTO dwelling (number, last_modified_at, start_measuring_day, stop_measuring_day,
                      created_at,
                      street_id)
VALUES ('13', now(), 10, 19, now(), 3);

-- section

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

-- floor

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

-- apartment

INSERT INTO apartment (number, type, owner, phone, created_at, last_modified_at, dwelling_id, floor_id)
VALUES (124, 'TWO_ROOM_APARTMENT', 'Кривцов Евгений Алексеевич', '', now(), now(), 1, 11);

INSERT INTO apartment (number, type, owner, phone, created_at, last_modified_at, dwelling_id, floor_id)
VALUES (163, 'TWO_ROOM_APARTMENT', 'Кривцов Алексей Иванович', '', now(), now(), 2, 29);

INSERT INTO apartment (number, type, owner, phone, created_at, last_modified_at, dwelling_id, floor_id)
VALUES (23, 'TWO_ROOM_APARTMENT', 'Кривцова Марина Владимировна', '', now(), now(), 3, 38);

-- heating

INSERT INTO heating (measure, created_at, last_modified_at, dwelling_id, apartment_id, month_id, year_id)
VALUES (15.0, now(), now(), 1, 1, 1, 2023);
INSERT INTO heating (measure, created_at, last_modified_at, dwelling_id, apartment_id, month_id, year_id)
VALUES (15.8, now(), now(), 1, 1, 2, 2023);
INSERT INTO heating (measure, created_at, last_modified_at, dwelling_id, apartment_id, month_id, year_id)
VALUES (16.1, now(), now(), 1, 1, 3, 2023);