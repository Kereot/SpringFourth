DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id serial, name VARCHAR(255), cost float, PRIMARY KEY (id));
INSERT INTO products (name, cost) VALUES ('Pen', 25),('Pineapple', 8), ('Apple', 20), ('Pen', 16);