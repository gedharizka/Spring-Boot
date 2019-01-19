insert into roles(id, name) values
(1, 'ROLE_ADMIN'), (2, 'ROLE_USER'),(3, 'ROLE_OPERATOR');

insert into users(id, uname, password, is_enabled) values
('001', 'admin', '$2a$11$rs1QsXV4iA0F3/rc4lPf5u2nSDhPbxmAnY4BvRgSoVIMDdjlNAZVe', true),
('002', 'user', '$2a$11$lWwWP0YWUVovprOPZcCFduGneka99pYcdwQEScosyQLCJiUcP.JJ2', true),
('003', 'disabledUser', '$2a$11$GeTM5PZ9zmHJHD3KN7BdjuJg03QDZ6SV0z2Jv/adYYNVEcq2YJunW', false);

insert into user_roles(id, user_id, role_id) values
(uuid(), '001', 1),
(uuid(), '001', 2),
(uuid(), '001', 3),
(uuid(), '002', 2),
(uuid(), '002', 3),
(uuid(), '003', 1);
