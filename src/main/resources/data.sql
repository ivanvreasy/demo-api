INSERT INTO privilege(name) values ('READ_PRIVILEGE');
INSERT INTO privilege(name) values ('WRITE_PRIVILEGE');
INSERT INTO privilege(name) values ('READ_USERS_PRIVILEGE');

INSERT INTO role(name) values ('ROLE_ADMIN');
INSERT INTO role(name) values ('ROLE_USER');

INSERT INTO roles_privileges(role_id, privilege_id) VALUES (
	(SELECT id FROM role WHERE name = 'ROLE_ADMIN'),
	(SELECT id FROM privilege WHERE name = 'READ_PRIVILEGE'),
);

INSERT INTO roles_privileges(role_id, privilege_id) VALUES (
	(SELECT id FROM role WHERE name = 'ROLE_ADMIN'),
	(SELECT id FROM privilege WHERE name = 'WRITE_PRIVILEGE'),
);

INSERT INTO roles_privileges(role_id, privilege_id) VALUES (
	(SELECT id FROM role WHERE name = 'ROLE_USER'),
	(SELECT id FROM privilege WHERE name = 'READ_PRIVILEGE'),
);

INSERT INTO roles_privileges(role_id, privilege_id) VALUES (
	(SELECT id FROM role WHERE name = 'ROLE_USER'),
	(SELECT id FROM privilege WHERE name = 'READ_USERS_PRIVILEGE'),
);