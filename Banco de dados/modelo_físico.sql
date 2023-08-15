Create database makeasy;

use makeasy;

/*1*/
/*tabela pai*/
create table add_conteudo(
cod_conteudo int primary key auto_increment,
arquivo_conteudo mediumblob not null
);
/*2*/
/*tabela pai*/
CREATE TABLE categoria(
id_cat int primary key auto_increment,
descricao varchar(50) not null,
tipo varchar(10) not null
);
/*3*/
/*tabela pai*/
CREATE TABLE ativo(
id_ativo int primary key auto_increment,
valor double not null,
descricao varchar(300) not null,
data_lancamento date not null
);
/*4*/
/*tabela pai*/
CREATE TABLE passivo(
id_passivo int primary key auto_increment,
valor double,
descricao varchar(300),
data_lancamento date

);
/*5*/
/*tabela pai*/
create table cadastro_prof(
rp int not null primary key auto_increment, 
Nome varchar(100) not null,
Sobrenome varchar(100) not null,
Cpf varchar(15) not null,
Rg varchar(14) not null,
Sexo varchar(14) not null,
Dt_nascimento date not null,
Upload_foto mediumblob null, 
Pergunta varchar(200) not null,
Resposta varchar(200) not null
);
/*6*/
/*tabela pai*/
Create table login(
cod_login int not null primary key auto_increment,
email varchar(100) not null,
Senha varchar(100) not null,
nivel varchar(3) not null,
fk_prof_rp INT,
FOREIGN KEY (fk_prof_rp) REFERENCES cadastro_prof (rp)
);
/*7*/
/*tabela pai*/
create table cad_aluno(
ra int primary key auto_increment,
nome varchar(75) not null,
sobrenome varchar(75) not null,
sexo varchar(14) not null,
cpf varchar(15) not null,
dt_nasc date not null,
pref_horario time null,
pref_dia varchar(20) null,
nivel_ingles varchar(50) not null,
foto_opcional mediumBlob null
/*nao recebe chaves estrangeiras*/
);
/*8*/
/*tabela pai*/
create table responsavel(
cod_resp int primary key auto_increment,
nome varchar(75) not null,
sobrenome varchar(75) not null,
sexo varchar(14) not null,
rg varchar(14) not null,
cpf varchar(15) not null,
dt_nasc date not null
);
/*9*/
/*tabela pai*/
Create table endereco(
cod_endereco int not null primary key auto_increment, 
numero varchar(10) not null,
Cidade varchar(100) not null,
cep varchar(14) not null,
uf varchar(14) not null,
Rua varchar(100) not null,
bairro varchar(100) not null,
complemento varchar(100) not null,

fk_prof_rp INT,
FOREIGN KEY (fk_prof_rp) REFERENCES cadastro_prof (rp),

fk_alun_ra int,
FOREIGN KEY (fk_alun_ra) REFERENCES cad_aluno (ra),

fk_cod_resp int,
FOREIGN KEY (fk_cod_resp) REFERENCES responsavel (cod_resp)
);
/*10*/
/*filha - aluno e ativo*/
create table aluno_ativo(
fk_aluno_ra int,
fk_id_ativo int
);

alter table aluno_ativo add constraint fk_aluno_ra foreign key (fk_aluno_ra) references cad_aluno(ra);
alter table aluno_ativo add constraint fk_id_ativo foreign key (fk_id_ativo) references ativo(id_ativo);
alter table aluno_ativo add constraint pk_Aluno_ativo primary key (fk_aluno_ra, fk_id_ativo);

/*11*/
/*tabela pai*/
create table telefone(
cod_tel int(50) primary key auto_increment,
tel_fixo varchar(50) null,
tel_celular varchar(50) null,
tel_emergencial varchar(50) null
/*nao recebe chaves estrangeiras*/   
);
/*12*/
/*filha - prof e telefone*/
create table tel_prof(

fk_prof_rp int,
fk_cod_tel int
);

alter table tel_prof add constraint pk_prof_telefone primary key (fk_prof_rp, fk_cod_tel);
alter table tel_prof add constraint fk_prof_rp foreign key (fk_prof_rp) references cadastro_prof(rp);
alter table tel_prof add constraint fk_cod_tel foreign key (fk_cod_tel) references telefone(cod_tel);
/*13*/
/*filha - aluno e telefone*/
create table tel_aluno(
fk_aluno_ra int,
fk_cod_tel int
);

alter table tel_aluno add constraint pk_aluno_telefone primary key (fk_aluno_ra, fk_cod_tel);
alter table tel_aluno add constraint fk_aluno_ra foreign key (fk_aluno_ra) references cad_aluno(ra);
alter table tel_aluno add constraint fk_cod_tel foreign key (fk_cod_tel) references telefone(cod_tel);
/*14*/
/*filha - resp e telefone*/
create table tel_resp(
fk_cod_resp int,
fk_cod_tel int
);

alter table tel_resp add constraint pk_resp_telefone primary key (fk_cod_resp, fk_cod_tel);
alter table tel_resp add constraint fk_cod_resp foreign key (fk_cod_resp) references responsavel(cod_resp);
alter table tel_resp add constraint fk_cod_tel foreign key (fk_cod_tel) references telefone(cod_tel);
/*15*/
/*tabela pai*/
Create table div_turma(
cod_turma int not null primary key auto_increment,
nome_turma varchar(20) not null,
dia_semana varchar(50) not null,
horario_dia time not null,
modalidade varchar(50) not null,

fk_prof_rp int,
FOREIGN KEY (fk_prof_rp) REFERENCES cad_prof (rp),

fk_aluno_ra int,
FOREIGN KEY (fk_aluno_ra) REFERENCES cad_aluno (ra)
);
/*16*/
/*tabela pai*/
create table chamada(
cod_chamada int not null primary key auto_increment,
data_chamada date not null,
presenca char(3) not null,
status_felicidade varchar(15) not null,
relatorio varchar(5000) not null 
);
/*17*/
/*filha - turma e chamada*/
create table turma_chamada(
fk_cod_chamada int,
fk_cod_turma int
);

alter table turma_chamada add constraint pk_turma_chamada primary key (fk_cod_chamada, fk_cod_turma);
alter table turma_chamada add constraint fk_cod_chamada foreign key (fk_cod_chamada) references chamada(cod_chamada);
alter table turma_chamada add constraint fk_cod_turma foreign key (fk_cod_turma) references div_turma(cod_turma);
/*18*/
/*filha - categoria e ativo*/
create table categ_ativo(
fk_id_cat int,
fk_id_ativo int
);

alter table categ_ativo add constraint pk_cat_ativo primary key (fk_id_cat, fk_id_ativo);
alter table categ_ativo add constraint fk_id_cat foreign key (fk_id_cat) references categoria(id_cat);
alter table categ_ativo add constraint fk_id_ativo foreign key (fk_id_ativo) references ativo(id_ativo);
/*19*/
/*filha - categoria e passivo*/
create table categ_passivo(

fk_id_cat int,
fk_id_passivo int
);

alter table categ_passivo add constraint pk_categ_passivo primary key (fk_id_cat, fk_id_passivo);
alter table categ_passivo add constraint fk_id_cat foreign key (fk_id_cat) references categoria(id_cat);
alter table categ_passivo add constraint fk_id_passivo foreign key (fk_id_passivo) references passivo(id_passivo);
/*20*/
/*filha - cad_prof e add_conteudo*/
create table prof_conteudo(
fk_prof_rp int,
fk_cod_conteudo int
);

alter table prof_conteudo add constraint pk_prof_conteudo primary key (fk_prof_rp, fk_cod_conteudo);
alter table prof_conteudo add constraint fk_prof_rp foreign key (fk_prof_rp) references cadastro_prof(rp);
alter table prof_conteudo add constraint fk_cod_conteudo foreign key (fk_cod_conteudo) references add_conteudo(cod_conteudo);
/*21*/
/*filha - resp e aluno*/
create table pai_filho(
fk_aluno_ra int,
fk_cod_resp int
);
alter table pai_filho add constraint pk_pai_filho primary key (fk_aluno_ra, fk_cod_resp);
alter table pai_filho add constraint fk_aluno_ra foreign key (fk_aluno_ra) references cad_aluno(ra);
alter table pai_filho add constraint fk_cod_resp foreign key (fk_cod_resp) references responsavel(cod_resp);


/*ABAIXO, NÓS VAMOS SABER COMO FUNCIONA O ESQUEMA DO 'MEDIUMBLOB'*/
/*
CREATE TABLE `arquivos` (
`arq_codigo` int(6) NOT NULL auto_increment,
`arq_ficheiro` mediumblob NOT NULL,
PRIMARY KEY  (`arq_codigo`)
) 

inserir os dados:
mysql> insert into arquivos (arq_ficheiro) values (LOAD_FILE('/tmp/01 Vertigo.mp3'));

importar:
mysql> source blobs.sql;

excluir os dados:
mysql> select arq_ficheiro from arquivos where arq_codigo = 1 
into outfile '/arquivos/01 Vertigo.mp3';


*/


