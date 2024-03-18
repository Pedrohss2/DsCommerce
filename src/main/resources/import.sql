INSERT INTO tb_category(name) VALUES ('Livros');
INSERT INTO tb_category(name) VALUES ('Eletronios');
INSERT INTO tb_category(name) VALUES ('Computadores');

INSERT INTO tb_product(name, description, price, img_url) VALUES ('Clean code', 'Livro que ensina como codar seguindo o códig limpo', 450.0, 'http://localhost');
INSERT INTO tb_product(name, description, price, img_url) VALUES ('Tv', 'Televisão 40 polegadas da LG', 4050.0, 'http://localhost');
INSERT INTO tb_product(name, description, price, img_url) VALUES ('Computador', 'Computador com 8 de ram paraa estudar programação', 2500.0, 'http://localhost');

INSERT INTO tb_product_category(product_id, category_id) VALUES (1, 1);
INSERT INTO tb_product_category(product_id, category_id) VALUES (2, 2);
INSERT INTO tb_product_category(product_id, category_id) VALUES (3, 3);

INSERT INTO tb_user(name, email, phone, birth_date, password) VALUES ('Pedro Henrique', 'pedro2266809ph@gamail.com', '43920005946', '2006-01-05', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user(name, email, phone, birth_date, password) VALUES ('Lorena', 'lorena@gmail.com', '439658458' ,'1999-03-09', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role(authority) VALUES ('ROLE_CLIENT');
INSERT INTO tb_role(authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role(user_id, role_id) VALUES (1,1);
INSERT INTO tb_user_role(user_id, role_id) VALUES (2,2);
INSERT INTO tb_user_role(user_id, role_id) VALUES (2,2);

INSERT INTO tb_order(moment, status, user_id) VALUES (TIMESTAMP WITHOUT TIME ZONE '2023-07-24T14:00:25Z', 1, 1);
INSERT INTO tb_order(moment, status, user_id) VALUES (TIMESTAMP WITHOUT TIME ZONE '2024-01-10T17:28:25Z', 1, 2);

INSERT INTO tb_order_item(order_id, product_id, quantity, price) VALUES (1, 1, 3, 450.0);
INSERT INTO tb_order_item(order_id, product_id, quantity, price) VALUES (2, 2, 3, 430.0);

INSERT INTO tb_payment(order_id, moment) VALUES (1,  TIMESTAMP WITHOUT TIME ZONE '2024-01-10T17:28:25Z');
INSERT INTO tb_payment(order_id, moment) VALUES (2,  TIMESTAMP WITHOUT TIME ZONE '2024-02-11T10:28:25Z');