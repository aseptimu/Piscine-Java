INSERT INTO "user" (login, password, created_rooms, chatrooms) VALUES ('aseptimu', '123', '{1, 2}', '{1, 3}');
INSERT INTO "user" (login, password, created_rooms, chatrooms) VALUES ('srobt', 'PUSSYKILLER', '{3}', '{1, 2, 3, 4, 5}');
INSERT INTO "user" (login, password, created_rooms, chatrooms) VALUES ('zelbocal', 'Boris', '{}', '{1, 2, 3, 4, 5}');
INSERT INTO "user" (login, password, created_rooms, chatrooms) VALUES ('mamka228', 'qwerty', '{}', '{1, 2, 3, 4, 5}');
INSERT INTO "user" (login, password, created_rooms, chatrooms) VALUES ('MrHunter', '*******', '{}', '{1, 2, 3, 4, 5}');

INSERT INTO chatroom (name, owner) VALUES ('general', 3);
INSERT INTO chatroom (name, owner) VALUES ('котики', 2);
INSERT INTO chatroom (name, owner) VALUES ('random', 4);
INSERT INTO chatroom (name, owner) VALUES ('aseptimu', 1);
INSERT INTO chatroom (name, owner) VALUES ('whoknowsme', 5);

INSERT INTO message (author, room, text, time) VALUES (1, 1, 'How to exit vim?', '2022-03-20 10:03:23');
INSERT INTO message (author, room, text, time) VALUES (2, 2, 'Kitties never die', '2022-03-20 11:03:23');
INSERT INTO message (author, room, text, time) VALUES (3, 1, 'Go away from Atlantis! Exam starts!', '2022-03-20 10:02:23');
INSERT INTO message (author, room, text, time) VALUES (4, 3, 'LOL KEK CHEBUREK', '2022-03-20 14:03:23');
INSERT INTO message (author, room, text, time) VALUES (5, 5, 'GonnaLeave', '2022-03-20 17:23:21');

