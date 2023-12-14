        INSERT INTO tbl_Coodinator (name_coordinator, pass_coordinator, phone_coordinator, email_coordinator) VALUES ('John Doe', 'password123', '123456789', 'johndoe@email.com');

        INSERT INTO tbl_discipline (name_discipline) VALUES ('Math');

        INSERT INTO tbl_hours (time_start, time_end, class_day, discipline_registred, course_registred, class_registred)
        VALUES 
        ('08:00', '10:00', 'Segunda-feira', 'Matemática', 'Engenharia', 'Sala 101'),
        ('09:00', '11:00', 'Terça-feira', 'Física', 'Ciência da Computação', 'Sala 102'),
        ('10:00', '12:00', 'Quarta-feira', 'História', 'Artes', 'Sala 103'),
        ('13:00', '15:00', 'Quinta-feira', 'Biologia', 'Medicina', 'Sala 104'),
        ('14:00', '16:00', 'Sexta-feira', 'Química', 'Farmácia', 'Sala 105'),
        ('15:00', '17:00', 'Sábado', 'Inglês', 'Letras', 'Sala 106'),
        ('16:00', '18:00', 'Domingo', 'Educação Física', 'Educação', 'Sala 107'),
        ('17:00', '19:00', 'Segunda-feira', 'Geografia', 'Geologia', 'Sala 108'),
        ('18:00', '20:00', 'Terça-feira', 'Economia', 'Administração', 'Sala 109'),
        ('19:00', '21:00', 'Quarta-feira', 'Sociologia', 'Ciências Sociais', 'Sala 110');


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