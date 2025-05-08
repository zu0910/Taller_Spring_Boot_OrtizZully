
USE exercise;

-- ------------------------------------------------------------------------------------------------------------

INSERT INTO skills (id, skill_name) VALUES (1, 'Programación Java');
INSERT INTO skills (id, skill_name) VALUES (2, 'Desarrollo Web');
select * from skills;
-- ------------------------------------------------------------------------------------------------------------

INSERT INTO chapters (id, numberchapter, skill_id, created_at, updated_at, description, chapter_summary) 
VALUES (1, 1, 1, '2025-05-08 10:00:00', '2025-05-08 10:00:00', 'Introducción a Java', 'Resumen de conceptos básicos de Java');

INSERT INTO chapters (id, numberchapter, skill_id , created_at, updated_at, description, chapter_summary) 
VALUES (3, 2, 1, '2025-05-08 10:05:00', '2025-05-08 10:05:00', 'Estructuras de Datos', 'Resumen de listas y arrays en Java');
select * from chapters;