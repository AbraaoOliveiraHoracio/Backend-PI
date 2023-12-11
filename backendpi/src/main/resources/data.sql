INSERT INTO tbl_Coodinator (name_coordinator, pass_coordinator, phone_coordinator, email_coordinator) VALUES ('John Doe', 'password123', '123456789', 'johndoe@email.com');

INSERT INTO tbl_discipline (name_discipline, min_size) VALUES ('Math', '20');

INSERT INTO tbl_hours (time_start, time_end, class_day, class_hour) VALUES ('08:00', '09:00', 'Monday', '1');

INSERT INTO tbl_student (name_student, email_student, phone_student, cpf_student) VALUES ('Jane Smith', 'janesmith@email.com', '1234567890', '1234567890');

INSERT INTO tbl_teacher (name_teacher, phone_teacher, cpf_teacher, discipline_teacher, email_teacher) VALUES
('João Silva', '9876543210', '9876543210', 'Mathematics', 'joaosilva@email.com'),
('Maria Oliveira', '5555555555', '5555555555', 'History', 'mariaoliveira@email.com'),
('Carlos Santos', '1111222233', '1111222233', 'Physics', 'carlossantos@email.com'),
('Ana Souza', '9999888877', '9999888877', 'Chemistry', 'anasouza@email.com'),
('Rodrigo Pereira', '7777666655', '7777666655', 'Biology', 'rodrigopereira@email.com'),
('Juliana Lima', '4444333322', '4444333322', 'Geography', 'julianalima@email.com'),
('Ricardo Mendes', '2222111100', '2222111100', 'Computer Science', 'ricardomendes@email.com'),
('Fernanda Costa', '8888777766', '8888777766', 'Physical Education', 'fernandacosta@email.com'),
('Daniel Rocha', '6666555544', '6666555544', 'Literature', 'danielrocha@email.com'),
('Mariana Cardoso', '3333222211', '3333222211', 'Music', 'marianacardoso@email.com');

INSERT INTO tbl_course (name_course, min_student, period_course) VALUES ('Computer Science', '20', 'Morning');

INSERT INTO tbl_classroom (capacity_room, type_room, floor_room) VALUES ('50', 'Lab', '2');