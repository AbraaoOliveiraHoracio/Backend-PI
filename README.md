# Backend-PI



## Designer

![image](https://github.com/AbraaoOliveiraHoracio/Backend-PI/assets/127244271/9bfbc7c1-859e-4408-84e3-952acc82ab46)




## Codigo do Banco



### Estrutura para tabela  aluno

 
CREATE TABLE `aluno` (
  `ID_Aluno` int(7) NOT NULL,
  `Email_Aluno` varchar(27) DEFAULT NULL,
  `Nome_Aluno` varchar(27) DEFAULT NULL,
  `Senha_Aluno` varchar(17) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
 
-- --------------------------------------------------------
 

### Estrutura para tabela  coordernador

 
CREATE TABLE `coordernador` (
  `ID_Coor` int(7) NOT NULL,
  `Email_Coor` varchar(27) DEFAULT NULL,
  `Nome_Coor` varchar(27) DEFAULT NULL,
  `Senha_Coor` varchar(17) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
 
-- --------------------------------------------------------
 

### Estrutura para tabela  curso

 
CREATE TABLE `curso` (
  `ID_Curso` int(7) NOT NULL,
  `Nome_Aluno` varchar(27) DEFAULT NULL,
  `Limite_De_Alunos` int(7) DEFAULT NULL,
  `Periodo_Curso` varchar(17) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
 
-- --------------------------------------------------------
 

### Estrutura para tabela  disciplina

 
CREATE TABLE `disciplina` (
  `ID_Disciplina` int(7) NOT NULL,
  `Nome_Disciplina` varchar(17) DEFAULT NULL,
  `Minimo_Disciplina` int(7) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
 
-- --------------------------------------------------------
 

### Estrutura para tabela  horario

 
CREATE TABLE `horario` (
  `ID_Horario` int(7) NOT NULL,
  `Data_Inicio` date DEFAULT NULL,
  `Data_Final` date DEFAULT NULL,
  `Dia` date DEFAULT NULL,
  `Hora` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
 
-- --------------------------------------------------------
 

### Estrutura para tabela  professor

 
CREATE TABLE `professor` (
  `ID_Professor` int(7) NOT NULL,
  `Email_Professor` varchar(27) DEFAULT NULL,
  `Nome_Professor` varchar(27) DEFAULT NULL,
  `Senha_Professor` varchar(17) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
 
-- --------------------------------------------------------
 

### Estrutura para tabela  reserva

 
CREATE TABLE `reserva` (
  `ID_Reserva` int(7) NOT NULL,
  `Disponibilidade_Reserva` varchar(17) NOT NULL,
  `Semestre_Reserva` varchar(17) NOT NULL,
  `ID_Aluno` int(7) NOT NULL,
  `ID_Coor` int(7) NOT NULL,
  `ID_Curso` int(7) NOT NULL,
  `ID_Horario` int(7) NOT NULL,
  `ID_Professor` int(7) NOT NULL,
  `ID_sala` int(7) NOT NULL,
  `ID_Disciplina` int(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
 
-- --------------------------------------------------------
 

### Estrutura para tabela sala

 
CREATE TABLE `sala` (
  `ID_Sala` int(7) NOT NULL,
  `Tipo_Sala` varchar(7) DEFAULT NULL,
  `Capacidade_Sala` int(7) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
 

## Índices para tabelas despejadas

 

### Índices de tabela  aluno

ALTER TABLE `aluno`
  ADD PRIMARY KEY (`ID_Aluno`),
  ADD KEY `ID_Aluno` (`ID_Aluno`);
 

### Índices de tabela  coordernador

ALTER TABLE `coordernador`
  ADD PRIMARY KEY (`ID_Coor`),
  ADD KEY `ID_Coor` (`ID_Coor`);
 

### Índices de tabela  curso

ALTER TABLE `curso`
  ADD PRIMARY KEY (`ID_Curso`),
  ADD KEY `ID_Curso` (`ID_Curso`);
 

### Índices de tabela  disciplina

ALTER TABLE `disciplina`
  ADD PRIMARY KEY (`ID_Disciplina`),
  ADD KEY `ID_Disciplina` (`ID_Disciplina`);
 

### Índices de tabela  horario

ALTER TABLE `horario`
  ADD PRIMARY KEY (`ID_Horario`),
  ADD KEY `ID_Horario` (`ID_Horario`);
 

### Índices de tabela  professor

ALTER TABLE `professor`
  ADD PRIMARY KEY (`ID_Professor`),
  ADD KEY `ID_Professor` (`ID_Professor`);
 

### Índices de tabela  reserva

ALTER TABLE `reserva`
  ADD PRIMARY KEY (`ID_Reserva`),
  ADD KEY `ID_Aluno` (`ID_Aluno`,`ID_Coor`,`ID_Curso`,`ID_Horario`,`ID_Professor`,`ID_sala`,`ID_Disciplina`),
  ADD KEY `ID_sala` (`ID_sala`),
  ADD KEY `ID_Professor` (`ID_Professor`),
  ADD KEY `ID_Disciplina` (`ID_Disciplina`),
  ADD KEY `ID_Curso` (`ID_Curso`),
  ADD KEY `ID_Horario` (`ID_Horario`),
  ADD KEY `ID_Coor` (`ID_Coor`);
 

### Índices de tabela  sala

ALTER TABLE `sala`
  ADD PRIMARY KEY (`ID_Sala`),
  ADD KEY `ID_Sala` (`ID_Sala`);
 

## AUTO_INCREMENT para tabelas despejadas

 

### AUTO_INCREMENT de tabela aluno

ALTER TABLE `aluno`
  MODIFY `ID_Aluno` int(7) NOT NULL AUTO_INCREMENT;
 

### AUTO_INCREMENT de tabela  coordernador

ALTER TABLE `coordernador`
  MODIFY `ID_Coor` int(7) NOT NULL AUTO_INCREMENT;
 

### AUTO_INCREMENT de tabela  curso

ALTER TABLE `curso`
  MODIFY `ID_Curso` int(7) NOT NULL AUTO_INCREMENT;
 

### AUTO_INCREMENT de tabela  disciplina

ALTER TABLE `disciplina`
  MODIFY `ID_Disciplina` int(7) NOT NULL AUTO_INCREMENT;
 

### AUTO_INCREMENT de tabela horario

ALTER TABLE `horario`
  MODIFY `ID_Horario` int(7) NOT NULL AUTO_INCREMENT;
 

### AUTO_INCREMENT de tabela professor

ALTER TABLE `professor`
  MODIFY `ID_Professor` int(7) NOT NULL AUTO_INCREMENT;
 

### AUTO_INCREMENT de tabela  reserva

ALTER TABLE `reserva`
  MODIFY `ID_Reserva` int(7) NOT NULL AUTO_INCREMENT;
 

###AUTO_INCREMENT de tabela  sala

ALTER TABLE `sala`
  MODIFY `ID_Sala` int(7) NOT NULL AUTO_INCREMENT;
 

## Restrições para tabelas despejadas

 

### Restrições para tabelas  reserva

ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`ID_sala`) REFERENCES `sala` (`ID_Sala`), 
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`ID_Professor`) REFERENCES `professor` (`ID_Professor`),
  ADD CONSTRAINT `reserva_ibfk_3` FOREIGN KEY (`ID_Disciplina`) REFERENCES `disciplina` (`ID_Disciplina`),
  ADD CONSTRAINT `reserva_ibfk_4` FOREIGN KEY (`ID_Curso`) REFERENCES `curso` (`ID_Curso`),
  ADD CONSTRAINT `reserva_ibfk_5` FOREIGN KEY (`ID_Horario`) REFERENCES `horario` (`ID_Horario`),
  ADD CONSTRAINT `reserva_ibfk_6` FOREIGN KEY (`ID_Aluno`) REFERENCES `aluno` (`ID_Aluno`),
  ADD CONSTRAINT `reserva_ibfk_7` FOREIGN KEY (`ID_Coor`) REFERENCES `coordernador` (`ID_Coor`);
COMMIT;
