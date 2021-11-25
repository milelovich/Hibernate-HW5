DROP TABLE users IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, score int, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO products (name, score) VALUES ('Milk', 80), ('Water', 50), ('Oil', 80);
