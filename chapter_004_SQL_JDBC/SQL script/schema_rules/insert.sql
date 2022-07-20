insert into role(name) values ('Beginner');
insert into users(name, role_id) values ('Ivan', 1);
insert into rules(name) values ('rule 1');
insert into role_rules(name, role_id, rules_id) values ('role to roles', 1, 1);
insert into category(name) values ('musical instruments');
insert into state(status) values ('In progress');
insert into item(name, users_id, category_id, state_id) values ('Item 1', 1, 1, 1);
insert into comments(description, item_id) values ('Faster', 1);
insert into attachs(name, item_id) values ('foto 1', 1);