#Questão 2
create database empresa;

use empresa;

create table departamento(
	nr_codigo int auto_increment,
	nome varchar(255) not null,
	primary key(nr_codigo)
);

create table funcionario(
	nr_codigo int auto_increment,
	nome varchar(255) not null,
	qtd_dependentes int default 0,
	salario float not null,
	cargo varchar(255) not null,
	nr_codigo_departamento int,
	primary key(nr_codigo),
	foreign key(nr_codigo_departamento)
		references departamento(nr_codigo)
);

#Questão 3
insert into departamento(nome)
values('TI');
insert into departamento(nome)
values('RH');
insert into departamento(nome)
values('Teste');
insert into departamento(nome)
values('Financeiro');
insert into departamento(nome)
values('Diretoria');
insert into departamento(nome)
values('DevOps');

commit;

insert into funcionario(nome, qtd_dependentes, salario, cargo, nr_codigo_departamento)
values('Lucas', 2, 12343.23, 'Desenvolvedor', 1);
insert into funcionario(nome, salario, cargo, nr_codigo_departamento)
values('Roberta', 133.33, 'Estagiária', 3);
insert into funcionario(nome, salario, cargo, nr_codigo_departamento)
values('Fredo', 1200.01, 'Pet de Apoio Emocional', 2);
insert into funcionario(nome, qtd_dependentes, salario, cargo, nr_codigo_departamento)
values('Vitória', 1, 1532.25, 'Vendedora', 4);
insert into funcionario(nome, salario, cargo, nr_codigo_departamento)
values('Jennifer', 1200.02, 'Estagiária', 4);
insert into funcionario(nome, qtd_dependentes, salario, cargo, nr_codigo_departamento)
values('Roberval', 5, 1500.03, 'Analista de Testes', 3);
insert into funcionario(nome, qtd_dependentes, salario, cargo, nr_codigo_departamento)
values('Edilson', 5, 15000.03, 'Diretor de Testes', 5);
insert into funcionario(nome, qtd_dependentes, salario, cargo, nr_codigo_departamento)
values('Ana', 1, 18000.03, 'Diretora de Desenvolvimento', 5);
insert into funcionario(nome, qtd_dependentes, salario, cargo, nr_codigo_departamento)
values('Joao', 2, 19000.03, 'Diretor de Financeiro', 5);
insert into funcionario(nome, salario, cargo, nr_codigo_departamento)
values('Robson', 21000.03, 'Diretor de RH', 5);
insert into funcionario(nome, qtd_dependentes, salario, cargo, nr_codigo_departamento)
values('Joao', 5, 15321.03, 'Gerente de DevOps', 6);
insert into funcionario(nome, qtd_dependentes, salario, cargo, nr_codigo_departamento)
values('Carlos', 5, 13990.2, 'Gerente de RH', 6);
insert into funcionario(nome, qtd_dependentes, salario, cargo, nr_codigo_departamento)
values('Carlos', 5, 13990.2, 'Gerente de RH', 2);

commit;

#Questão 4.a
CREATE or replace VIEW DEP_MAIOR_QTD_FUNC AS
select count(f.nr_codigo) num_funcionarios, d.nome
from departamento d,
	 funcionario f
where d.nr_codigo = f.nr_codigo_departamento
group by d.nome
having num_funcionarios = (select max(funcionarios.total)
						   from (select count(nr_codigo) total
						   		 from funcionario
						   		 group by nr_codigo_departamento) funcionarios);

commit;

#Questão 4.b
CREATE OR REPLACE VIEW DEPS_COM_MENOS_FUNC_SEM_DEP as
SELECT func_sem_dependentes.nome,
  	   func_sem_dependentes.qtd_zero_dependentes
FROM (SELECT d.nome,
    		 COUNT(f.nr_codigo) AS qtd_zero_dependentes
  	  FROM departamento d
  	  LEFT JOIN funcionario f
      ON f.nr_codigo_departamento = d.nr_codigo
      AND f.qtd_dependentes = 0
      GROUP BY d.nr_codigo, d.nome) AS func_sem_dependentes
WHERE
  func_sem_dependentes.qtd_zero_dependentes = (SELECT MIN(sub.menor_qtd)
    										   FROM (SELECT COUNT(f2.nr_codigo) AS menor_qtd
      	  											 FROM departamento d2
      	  											 LEFT JOIN funcionario f2
          											 ON f2.nr_codigo_departamento = d2.nr_codigo
          											 AND f2.qtd_dependentes = 0
          											 GROUP BY d2.nr_codigo) AS sub);

commit;

#Questão 4.c
CREATE OR REPLACE VIEW DEPART_COMECA_DIR AS
select d.nome NOME_DEPARTAMENTO, f.nome NOME_FUNCIONARIO
from departamento d,
	 funcionario f
where upper(d.nome) like 'DIR%'
and d.nr_codigo = f.nr_codigo_departamento;

commit;

#Questão 4.d
CREATE OR REPLACE VIEW FUNC_MAIOR_SALARIO AS
select f.nome NOME_FUNCIONARIO, d.nome NOME_DEPARTAMENTO
from funcionario f,
	 departamento d
where f.salario = (select max(salario) from funcionario)
and d.nr_codigo = f.nr_codigo_departamento;

commit;

#Questão 4.e
CREATE OR REPLACE VIEW GERENTES_DE_CADA_DEPARTAMENTO AS
select f.nome NOME_FUNCIONARIO, d.nome NOME_DEPARTAMENTO
from funcionario f,
	 departamento d
where upper(cargo) like 'GERENTE%'
and d.nr_codigo = f.nr_codigo_departamento;

commit;

#Questão 5
create user 'gerente'@'localhost' identified by 'admin';
create user 'funcionario'@'localhost' identified by 'func';
GRANT ALL PRIVILEGES ON empresa.* TO 'gerente'@localhost;
GRANT SELECT, SHOW VIEW ON empresa.* TO 'funcionario'@localhost;
FLUSH PRIVILEGES;
