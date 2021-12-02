DROP TABLE customers IF EXISTS CASCADE;
CREATE TABLE IF NOT EXISTS customers (id bigserial PRIMARY KEY, name VARCHAR(100));
INSERT INTO customers (name) VALUES ('Beethoven'), ('Van Gogh'), ('Morgenshtern');

DROP TABLE products If EXISTS CASCADE;
CREATE TABLE IF NOT EXISTS products (id bigserial PRIMARY KEY , title VARCHAR(100), cost integer);
INSERT INTO products (title, cost) VALUES ('Hearing', 70), ('Ear', 40), ('Talent', 200);

DROP TABLE orders If EXISTS CASCADE;
CREATE TABLE IF NOT EXISTS orders (id bigserial PRIMARY KEY, customer_id bigint REFERENCES customers (id), product_id bigint REFERENCES products (id), product_cost integer);
INSERT INTO orders (customer_id, product_id, product_cost) VALUES (1, 1, 90), (2, 2, 10), (3, 3, 180), (3, 1, 90);



