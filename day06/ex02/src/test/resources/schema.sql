DROP TABLE IF EXISTS product;

CREATE TABLE IF NOT EXISTS product (
   identifier INT PRIMARY KEY IDENTITY,
   name varchar(50),
    price int
);
