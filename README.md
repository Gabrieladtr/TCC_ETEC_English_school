# TCC_ETEC_English_school

Instruções para funcionamento do código fonte do sistema:

------------------------------------

Links dos programas necessários para funcionamento do sistema:

Wamp:
https://sourceforge.net/projects/wampserver/files/

Java (JRE):
https://www.java.com/pt-BR/download/ie_manual.jsp?locale=pt_BR

MySQL Workbench: (gerenciador de banco de dados)
https://dev.mysql.com/downloads/workbench/


------------------------------------

1º - Criando e inserindo informações no banco de dados:

->Instale o Wamp. Esse programa possui um sistema onde cria um servidor, esse servidor será usado para conectar o programa com o banco de dados.
	->O wamp vem com o mySql, PHP, MariaDB etc.
	->Instale o Workbench ou algum outro gerenciador de banco de dados
	->Entre na pasta "banco de dados" e copie tudo o conteudo do arquivo "modelo_físico" 
	->Execute no workbench
	->Depois execute o conteúdo do "Insert de dados", para inserir as informações do sistema.
		->É muito importante que vc crie o banco e insira as informações, pois somente com o login cadastrado será 		possível entrar no sistema!!

------------------------------------

2º - Execução do programa:

->Com todas as informações inseridas vamos precisar fazer o login:
	-->Instale o Java (JRE) (não é necessário o JDK, a não ser que queira alterar o código fonte e compilá-lo)
		->Na pasta "Dist/TCCv2.Executable Jar File" é o programa executável.
		->Com o Java instalado, será possível executar o Jar, que é esse programa.
		->Ou com a pasta aberta no CMD use esse comando: java -jar "TCCv2.jar" 

------------------------------------

3º Possíveis falhas com o banco de dados:

Se a conexão com o banco de dados der falhas provavelmente é por causa de algum problema com o servidor. Erros como "Não conectou com o banco de dados".
Normalmente quando se há algum problema com o servidor podemos abrir o programa via CMD para ter um relatório de erros.


Eu tive o seguinte erro: "Unknown initial character set index '255' received from server. Initial client character set can be forced via the 'characterEncoding' property."

Basicamente o MySQL está tentando formatar um tipo de caractere que não consegue conversar com o JDBC, que é o sistema que verifica a conexão com banco de dados no Java.

Para resolver é bem simples. Vamos configurar o MySQL para que entenda que a formatação que estamos usando é UTF-8.
ara configurar o MySQL para usar o conjunto de caracteres UTF-8 via linha de comando (cmd), você precisará fazer algumas alterações no arquivo de configuração do MySQL (my.ini no Windows). Siga estas etapas:

Encontre o Arquivo my.ini:
Geralmente, o arquivo my.ini está localizado na pasta de instalação do MySQL. No WAMP, você pode encontrá-lo em algo como C:\wamp\bin\mysql\mysql{versão}\my.ini.

Faça um Backup do Arquivo my.ini:
Antes de fazer qualquer alteração, é sempre uma boa prática fazer um backup do arquivo my.ini para que você possa restaurá-lo, se necessário.

Abra o Arquivo my.ini em um Editor de Texto:
Use um editor de texto como o Bloco de Notas para abrir o arquivo my.ini.

Encontre a Seção [mysqld]:
Role o arquivo até encontrar a seção [mysqld].

Adicione ou Modifique as Linhas de Configuração:
Dentro da seção [mysqld], adicione ou modifique as seguintes linhas para definir o conjunto de caracteres padrão como UTF-8 e também configurar o collation:

Adicione essas informações:
[mysqld]
character-set-server=utf8
collation-server=utf8_general_ci
init-connect='SET NAMES utf8'

Salve o Arquivo my.ini:
Depois de fazer as alterações, salve o arquivo my.ini.

Reinicie o Servidor MySQL:
Reinicie o servidor MySQL para que as alterações no arquivo de configuração entrem em vigor. Você pode fazer isso via WAMP ou pelo cmd usando o comando:

net stop MySQL
net start MySQL

Eu particularmente acredito que seja mais simples apenas reiniciar o servidor via WAMP. Para isso é só clicar no ícone do wamp (que deve estar verde, amarelo ou vermelho) no canto inferior direito do windows e clicar em reinicar todos os serviços.

Depois execute novamente o programa e tente logar no sistema.

------------------------------------

4º - Possíveis erros de login:

No sistema temos 2 tipos de acesso:

1º: ADM = Administrador total. Possui acesso total ao sistema;
2º: PRO = Possui acesso de professor. Não possui acesso total no sistema.

No banco de dados há uma tabela de login. Essa tabela deve ter 2 usuários com acessos como padrão, que está no arquivo de insert de dados:


-- Tabela login: usuario administrador e usuario normal
INSERT INTO login (email, Senha, nivel, fk_prof_rp)
VALUES ('adm@example.com', 'senha123', 'ADM', 1);
VALUES ('professor@example.com', 'senha123', 'PRO', 2);


Você deve logar com algum desses acessos para entrar no sistema. Caso no arquivo de insert não haja nenhum cadastro de login, vc precisará entrar no localhost via navegador padrão do sistema, e depois acessar o PHPmyAdmin ou até mesmo o próprio workbench. O Workbench vai precisar inserir essas informações na tabela de login para que o sistema indentifique no banco de dados que tem um acesso de ADM ou PRO possível. Dessa forma, é possível entrar no sistema.


------------------------------------

5º Espero que o sistema atenda as suas necessidades!






























	

 
