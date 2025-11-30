-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

INSERT INTO Campus (nome, cidade) VALUES ('Campus Porto Alegre', 'Porto Alegre');
INSERT INTO Campus (nome, cidade) VALUES ('Campus Alvorada', 'Alvorada');
INSERT INTO Campus (nome, cidade) VALUES ('Campus Canoas', 'Canoas');
INSERT INTO Campus (nome, cidade) VALUES ('Campus Osório', 'Osório');
INSERT INTO Campus (nome, cidade) VALUES ('Reitoria', 'Bento Gonçalves');

-- 1. Campus Salvador (ID 1)
INSERT INTO Curso (nivel, nome, id_campus)
VALUES ('GRADUACAO', 'Engenharia de Computação', 1);

-- 2. Campus Bauru (ID 2)
INSERT INTO Curso (nivel, nome, id_campus)
VALUES ('TECNICO', 'Mecatrônica Integrado', 2);

-- 3. Campus Canoas (ID 3)
INSERT INTO Curso (nivel, nome, id_campus)
VALUES ('POS', 'Gestão Ambiental', 3);

-- 4. Campus Osório (ID 4)
INSERT INTO Curso (nivel, nome, id_campus)
VALUES ('GRADUACAO', 'Design Gráfico', 4);

-- 5. Campus Apodi (ID 5)
INSERT INTO Curso (nivel, nome, id_campus)
VALUES ('TECNICO', 'Agropecuária Subsequente', 5);