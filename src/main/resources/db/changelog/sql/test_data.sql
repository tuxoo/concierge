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

INSERT INTO section (number, created_at, dwelling_id)
VALUES (1, now(), 1);
INSERT INTO section (number, created_at, dwelling_id)
VALUES (2, now(), 1);

INSERT INTO section (number, created_at, dwelling_id)
VALUES (1, now(), 2);
INSERT INTO section (number, created_at, dwelling_id)
VALUES (2, now(), 2);
INSERT INTO section (number, created_at, dwelling_id)
VALUES (3, now(), 2);
INSERT INTO section (number, created_at, dwelling_id)
VALUES (4, now(), 2);
INSERT INTO section (number, created_at, dwelling_id)
VALUES (5, now(), 2);
INSERT INTO section (number, created_at, dwelling_id)
VALUES (6, now(), 2);
INSERT INTO section (number, created_at, dwelling_id)
VALUES (7, now(), 2);
INSERT INTO section (number, created_at, dwelling_id)
VALUES (8, now(), 2);
INSERT INTO section (number, created_at, dwelling_id)
VALUES (9, now(), 2);
INSERT INTO section (number, created_at, dwelling_id)
VALUES (10, now(), 2);

INSERT INTO section (number, created_at, dwelling_id)
VALUES (1, now(), 3);
INSERT INTO section (number, created_at, dwelling_id)
VALUES (2, now(), 3);
INSERT INTO section (number, created_at, dwelling_id)
VALUES (3, now(), 3);
INSERT INTO section (number, created_at, dwelling_id)
VALUES (4, now(), 3);
INSERT INTO section (number, created_at, dwelling_id)
VALUES (5, now(), 3);
INSERT INTO section (number, created_at, dwelling_id)
VALUES (6, now(), 3);

-- floor

INSERT INTO floor (number, created_at, section_id)
VALUES (1, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (2, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (3, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (4, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (5, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (6, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (7, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (8, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (9, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (10, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (11, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (12, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (13, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (14, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (15, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (16, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (17, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (18, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (19, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (20, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (21, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (22, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (23, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (24, now(), 1);
INSERT INTO floor (number, created_at, section_id)
VALUES (25, now(), 1);

INSERT INTO floor (number, created_at, section_id)
VALUES (1, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (2, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (3, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (4, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (5, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (6, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (7, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (8, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (9, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (10, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (11, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (12, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (13, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (14, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (15, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (16, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (17, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (18, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (19, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (20, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (21, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (22, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (23, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (24, now(), 2);
INSERT INTO floor (number, created_at, section_id)
VALUES (25, now(), 2);

INSERT INTO floor (number, created_at, section_id)
VALUES (1, now(), 7);
INSERT INTO floor (number, created_at, section_id)
VALUES (2, now(), 7);
INSERT INTO floor (number, created_at, section_id)
VALUES (3, now(), 7);
INSERT INTO floor (number, created_at, section_id)
VALUES (4, now(), 7);
INSERT INTO floor (number, created_at, section_id)
VALUES (5, now(), 7);
INSERT INTO floor (number, created_at, section_id)
VALUES (6, now(), 7);
INSERT INTO floor (number, created_at, section_id)
VALUES (7, now(), 7);
INSERT INTO floor (number, created_at, section_id)
VALUES (8, now(), 7);
INSERT INTO floor (number, created_at, section_id)
VALUES (9, now(), 7);

INSERT INTO floor (number, created_at, section_id)
VALUES (1, now(), 14);
INSERT INTO floor (number, created_at, section_id)
VALUES (2, now(), 14);
INSERT INTO floor (number, created_at, section_id)
VALUES (3, now(), 14);
INSERT INTO floor (number, created_at, section_id)
VALUES (4, now(), 14);
INSERT INTO floor (number, created_at, section_id)
VALUES (5, now(), 14);

-- apartment

INSERT INTO apartment (number, type, owner, phone, created_at, last_modified_at, dwelling_id, floor_id)
VALUES (121, 'THREE_ROOM_APARTMENT', '', '', now(), now(), 1, 36);
INSERT INTO apartment (number, type, owner, phone, created_at, last_modified_at, dwelling_id, floor_id)
VALUES (122, 'ONE_ROOM_APARTMENT', '', '', now(), now(), 1, 36);
INSERT INTO apartment (number, type, owner, phone, created_at, last_modified_at, dwelling_id, floor_id)
VALUES (123, 'ONE_ROOM_APARTMENT', '', '', now(), now(), 1, 36);
INSERT INTO apartment (number, type, owner, phone, created_at, last_modified_at, dwelling_id, floor_id)
VALUES (124, 'TWO_ROOM_APARTMENT', 'Кривцов Евгений Алексеевич', '', now(), now(), 1, 36);
INSERT INTO apartment (number, type, owner, phone, created_at, last_modified_at, dwelling_id, floor_id)
VALUES (125, 'ONE_ROOM_APARTMENT', '', '', now(), now(), 1, 36);
INSERT INTO apartment (number, type, owner, phone, created_at, last_modified_at, dwelling_id, floor_id)
VALUES (126, 'ONE_ROOM_APARTMENT', '', '', now(), now(), 1, 36);

INSERT INTO apartment (number, type, owner, phone, created_at, last_modified_at, dwelling_id, floor_id)
VALUES (162, 'THREE_ROOM_APARTMENT', '', '', now(), now(), 2, 54);
INSERT INTO apartment (number, type, owner, phone, created_at, last_modified_at, dwelling_id, floor_id)
VALUES (163, 'TWO_ROOM_APARTMENT', 'Кривцов Алексей Иванович', '', now(), now(), 2, 54);

INSERT INTO apartment (number, type, owner, phone, created_at, last_modified_at, dwelling_id, floor_id)
VALUES (23, 'TWO_ROOM_APARTMENT', 'Кривцова Марина Владимировна', '', now(), now(), 3, 63);

-- heating

INSERT INTO heating (measure, created_at, last_modified_at, dwelling_id, apartment_id, month_id, year_id)
VALUES (15.0, now(), now(), 1, 4, 1, 2023);
INSERT INTO heating (measure, created_at, last_modified_at, dwelling_id, apartment_id, month_id, year_id)
VALUES (15.8, now(), now(), 1, 4, 2, 2023);
INSERT INTO heating (measure, created_at, last_modified_at, dwelling_id, apartment_id, month_id, year_id)
VALUES (16.1, now(), now(), 1, 4, 3, 2023);