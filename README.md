# Backend-PI


## Dependências:

<dependencies>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>


# Testes JUnit

	getStudentById_Success:
	Descrição: Testa se a função getStudents do serviço retorna um aluno existente com sucesso.
	Cenário de Sucesso: O repositório retorna um objeto Optional contendo o aluno existente, e a função getStudents retorna o mesmo aluno.
	Cenário de Falha: A função getStudents não retorna o aluno esperado.
	
 	getStudentById_NonExistentId:
	Descrição: Testa se a função getStudents do serviço lança uma exceção EntityNotFoundException quando o ID do aluno não existe.
	Cenário de Sucesso: O repositório retorna um Optional vazio, e a exceção EntityNotFoundException é lançada.
	Cenário de Falha: A exceção lançada não é EntityNotFoundException, ou o repositório retorna um aluno, o que é inesperado neste caso.
	
 	saveStudent_Success:	
	Descrição: Testa se a função save do serviço salva um novo aluno com sucesso.
	Cenário de Sucesso: O repositório retorna um novo objeto Student após a chamada do método save, e a função save do serviço retorna um objeto StudentResponse não nulo.
	Cenário de Falha: O objeto retornado pela função save do serviço é nulo ou o repositório não retorna um novo objeto Student após a chamada do método save.



#
