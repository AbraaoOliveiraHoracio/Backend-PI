INSERT INTO tbl_Coodinator (name_coordinator, pass_coordinator, phone_coordinator, email_coordinator) VALUES ('John Doe', 'password123', '123456789', 'johndoe@email.com');

INSERT INTO tbl_discipline (name_discipline) VALUES ('Math');

INSERT INTO tbl_hours (time_start, time_end, class_day, class_hour) VALUES ('08:00', '09:00', 'Monday', '1');

INSERT INTO tbl_student (name_student, email_student, phone_student, cpf_student) VALUES ('Jane Smith', 'janesmith@email.com', '1234567890', '1234567890');

INSERT INTO tbl_teacher (name_teacher, email_teacher,pass_teacher) VALUES
('João Silva',  'joaosilva@email.com','Senha'),
('Maria Oliveira',  'mariaoliveira@email.com','Senha'),
('Carlos Santos',  'carlossantos@email.com','Senha'),
('Ana Souza', 'anasouza@email.com','Senha'),
('Rodrigo Pereira', 'rodrigopereira@email.com','Senha'),
('Juliana Lima', 'julianalima@email.com','Senha'),
('Ricardo Mendes', 'ricardomendes@email.com','Senha'),
('Fernanda Costa', 'fernandacosta@email.com','Senha'),
('Daniel Rocha', 'danielrocha@email.com','Senha'),
('Mariana Cardoso', 'marianacardoso@email.com','Senha');

INSERT INTO tbl_course (name_course, min_student, period_course) VALUES ('Computer Science', '20', 'Morning');

INSERT INTO tbl_classroom (capacity_room, type_room, floor_room) VALUES ('50', 'Lab', '2');