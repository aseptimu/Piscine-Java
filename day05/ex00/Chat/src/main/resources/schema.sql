CREATE TABLE IF NOT EXISTS "user" (
    id SERIAL PRIMARY KEY,
    login text NOT NULL,
    password text NOT NULL
);

CREATE TABLE IF NOT EXISTS chatroom (
    id SERIAL PRIMARY KEY,
    name text NOT NULL,
    owner int NOT NULL REFERENCES "user"(id)
);

CREATE TABLE IF NOT EXISTS message (
  id SERIAL PRIMARY KEY,
  author int NOT NULL REFERENCES "user"(id),
  room int NOT NULL REFERENCES chatroom(id),
  text text,
  time timestamp NOT NULL
);