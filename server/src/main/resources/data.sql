insert into AIRPORT_MEETING_POINT(ID, NAME, DESCRIPTION) VALUES(1, 'Starbucks na WAW', 'Opis!');

insert into AIRPORTS(ID, CODE, NAME, LATITUDE, LONGITUDE, MEETING_POINT_ID) VALUES(1, 'WAW', 'Warsaw Chopin Airport', 52.159499362, 20.966996132, 1);
insert into AIRPORTS(ID, CODE, NAME, LATITUDE, LONGITUDE) VALUES(2, 'WMI', 'Warsaw Modlin Airport', 52.450664864, 20.650997396);
insert into AIRPORTS(ID, CODE, NAME, LATITUDE, LONGITUDE) VALUES(3, 'SIN', 'Singapore Changi Airport', 1.345010, 103.983208);
insert into AIRPORTS(ID, CODE, NAME, LATITUDE, LONGITUDE) VALUES(4, 'AAA', 'Anaa Airport', -17.3489, -145.513);
insert into AIRPORTS(ID, CODE, NAME, LATITUDE, LONGITUDE) VALUES(5, 'AAB', 'Arrabury Airport', -26.7, 141.05);

insert into USER(ID, USERNAME, PASSWORD)
VALUES (1, 'lukasz', '$2a$10$Y.fCHmgYXmhPX6qdpeAJx.3JDwPN8gsRMCu3UFC68h/5JECDJHwzi');
insert into USER(ID, USERNAME, PASSWORD)
VALUES (2, 'marta', '$2a$10$Y.fCHmgYXmhPX6qdpeAJx.3JDwPN8gsRMCu3UFC68h/5JECDJHwzi');
insert into USER(ID, USERNAME, PASSWORD)
VALUES (3, 'ola', '$2a$10$Y.fCHmgYXmhPX6qdpeAJx.3JDwPN8gsRMCu3UFC68h/5JECDJHwzi');

insert into JPA_TRAVELER_PROFILE(TRAVELER_ID, NATIONALITY, NICKNAME)
VALUES (1, 'PORTUGAL', 'Friendly mark');
insert into JPA_TRAVELER_PROFILE(TRAVELER_ID, NATIONALITY, NICKNAME)
VALUES (2, 'POLAND', 'Alan the funny guy');
insert into JPA_TRAVELER_PROFILE(TRAVELER_ID, NATIONALITY, NICKNAME)
VALUES (3, 'IRELAND_REPUBLIC', 'Alan not so funny guy');

insert into TRAVELER_LANGUAGES(TRAVELER_ID, LANGUAGES)
VALUES (1, 'PORTUGUESE');
insert into TRAVELER_LANGUAGES(TRAVELER_ID, LANGUAGES)
VALUES (1, 'ENGLISH');
insert into TRAVELER_LANGUAGES(TRAVELER_ID, LANGUAGES)
VALUES (2, 'POLISH');
insert into TRAVELER_LANGUAGES(TRAVELER_ID, LANGUAGES)
VALUES (2, 'ENGLISH');
insert into TRAVELER_LANGUAGES(TRAVELER_ID, LANGUAGES)
VALUES (3, 'ENGLISH');

insert into JPA_NEED_EVENT(ID, TRAVELER_ID, AIRPORT_ID, AVAILABLE_FROM, AVAILABLE_TO)
VALUES (1, 2, 1, '2019-09-14T01:00:00.000', '2019-09-15T23:59:00.000');
insert into EVENT_NEEDS(NEED_EVENT_ID, NEED)
VALUES (1, 'EAT');
insert into EVENT_NEEDS(NEED_EVENT_ID, NEED)
VALUES (1, 'DRINK');

insert into JPA_NEED_EVENT(ID, TRAVELER_ID, AIRPORT_ID, AVAILABLE_FROM, AVAILABLE_TO)
VALUES (2, 3, 1, '2019-09-14T01:00:00.000', '2019-09-15T23:59:00.000');
insert into EVENT_NEEDS(NEED_EVENT_ID, NEED)
VALUES (2, 'EAT');
insert into EVENT_NEEDS(NEED_EVENT_ID, NEED)
VALUES (2, 'CHAT');

