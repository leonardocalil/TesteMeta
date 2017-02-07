Pré-requisitos:


Banco de dados: Postgres versão 9.x
Base de dados: No postgres, criar uma nova base de dados com o nome: testemeta

Servidor Web: Apache tomcat 7.x

-------------------------------------------------------
Instalação:

- Importar o projeto no eclipse;
- Gerar o arquivo WAR (botão direito em cima do projeto, export -> war file) 
  ou apenas publicar o projeto no Servidor Tomcat7 e clicar em executar;
-------------------------------------------------------  
Validações:


- Validar configuração Spring:
--> validar os arquivos web.xml e dispatcher-servlet.xml 
--> Acessar o link: http://localhost:8080/TesteMeta/spring/

- Validar configuração e aplicação primefaces: 
--> validar o arquivo web.xml
--> Acessar o link: http://localhost:8080/TesteMeta/primefaces/index.faces 
    e validar as operações de Listar / Cadastrar / Editar / Excluir
    
- Validar endpoint rest:

--> validar o arquivo web.xml
--> Link: http://localhost:8080/TesteMeta/rest/user/All 

	@GET
	@Path("All")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserEntity> all()

--> Link: http://localhost:8080/TesteMeta/rest/user/Create	

	@POST
	@Path("Create")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean create(String json) 
	

--> Link: http://localhost:8080/TesteMeta/rest/user/Read/1		
		
	@GET
	@Path("Read/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserEntity get(@PathParam("id") String id)

--> Link: http://localhost:8080/TesteMeta/rest/user/Update
		
	@POST
	@Path("Update")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean Update(String json)

--> Link: http://localhost:8080/TesteMeta/rest/user/Delete/1
	
	@GET
	@Path("Delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean delete(@PathParam("id") String id)


*** Obs: Os metodos que são do tipo POST, deve ser enviado o JSON representando a classe UserEntity	
------------------------------------------------------

*** Nesta versão nao foi implementado JMS e testes unitarios