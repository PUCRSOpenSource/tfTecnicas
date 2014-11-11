#Final Assingment - Programming Techniques course

###Ostrich Informatics - Team

* [Candice Michelon](https://github.com/CanTM)
* [Giovanni Cupertino](https://github.com/GiovanniCuper)
* [Matthias Nunes](https://github.com/execb5)

######Data de entrega: 25/11/2014
######Apresentações: 25/11/2014

##Objetivo

O objetivo deste trabalho é consolidar o conhecimento sobre conceitos e
construção de sistemas empresariais orientados a objetos em arquiteturas
multicamadas através da exploração dos tópicos discutidos na disciplina de
Técnicas de Programação.

##Enunciado do problema

Estamos interessados no desenvolvimento de um sistema de informação para uma
cadeia de salas de cinema. Esse sistema deve permitir a visualização de
informações de filmes e a compra de ingressos. Os seguintes casos de uso devem
ser implementados.

<u>Usuário: cliente do cinema</u>

* Visualizar informações de filmes, datas/horários, sessões de exibição, valor
  do ingresso e se existe ou não disponibilidade de ingressos para venda. Todo
  filme deve possuir pelo menos as informações de nome, foto do cartaz, ano de
  lançamento, sinopse, diretor e principais atores. A disponibilidade de
  ingressos para venda depende da lotação máxima disponível em cada sala de
  exibição, bem como da data/horário (não é permitida a venda de ingressos para
  seções que já iniciaram ou em datas passadas). A busca pelas informações pode
  ser feita através de uma data informada ou pelo nome do filme.

* Realizar a compra de ingressos para uma determinada sessão de um determinado
  dia/horário. O cliente pode comprar a quantidade de ingressos que desejar,
  desde que estejam disponíveis. Ao realizar a compra, o usuário deve também
  informar o número de cada cadeira associado ao ingresso e a idade de quem irá
  ocupar a cadeira. Veja regras de negócio importantes sobre esse caso de uso a
  seguir.

<u>Usuário: gerente do cinema</u>

* Adicionar um novo filme para exibição. Veja regra de negócio importante sobre
  esse caso de uso a seguir.

* Adicionar uma nova sessão de exibição de um filme.

* Obter a informação do total de vendas para cada filme e sala de exibição por
  dia. A data deve ser informada pelo gerente.

<u>Regras de negócio importantes:</u>

* As informações associadas aos filmes são obtidas de um sistema externo
  chamado “TMDB – The Movie Database”(https://www.themoviedb.org). Ao cadastrar
  um filme no sistema, as informações devem ser obtidas do TMDB e armazenadas
  em uma base local a fim de otimizar o acesso futuro aos dados. A API de
  acesso em Java e um exemplo de código de acesso se encontra no Moodle.

* Uma venda somente é finalizada se existe a disponibilidade real do ingresso,
  ou seja, a cadeira desejada deve estar disponível. É importante que o sistema
  lide com a possibilidade de acessos concorrentes de vários usuários.

* O valor final a ser pago pelo ingresso depende de vários fatores. Caso o
  ingresso seja para uma pessoa menor de idade (12 anos ou menos), o desconto é
  de 50%; já para idosos (65 anos ou mais), o desconto é de 40%. O cinema
  permite ainda a venda de pacotes (com no mínimo 5 ingressos) com um desconto
  adicional de 5% para cada ingresso.

<u>Script SQL</u>

```sql

create table horarios( id int primary key not null
                     , inicio char(5) not null
                     , fim char(5) not null
                     );

insert into horarios values (1,'14:00','16:00');

create table salas( id int primary key not null
                  , capacidade int not null
                  );

insert into salas values (1, 100);

create table filmes( id int primary key not null
                   , nome varchar(300) not null
                   , cartaz varchar(300)
                   , anolancamento int
                   , sinopse varchar(600)
                   , diretor varchar(300)
                   , atores varchar(600)
                   );

insert into filmes values ( 118340
                          , 'Guardians of the Galaxy'
                          , 'http://image.tmdb.org/t/p/w185/9gm3lL8JMTTmc3W4BmNMCuRLdL8.jpg'
                          , 2014
                          , 'Light years from Earth, 26 years after being abducted, Peter Quill finds himself the prime target of a manhunt after discovering an orb wanted by Ronan the Accuser.'
                          , 'James Gunn'
                          , 'Chris Pratt, Zoe Saldana, Dave Bautista, Vin Diesel'
                          );

create table sessoes( id int primary key not null generated always as identity (start with 1, increment by 1)
                    , dia date not null
                    , vagas int not null
                    , valorintegral real not null
                    , idsala int not null
                    , idhorario int not null
                    , idfilme int not null
                    , constraint fk_sessoes_salas foreign key (idsala) references salas(id)
                    , constraint fk_sessoes_horarios foreign key (idhorario) references horarios(id)
                    , constraint fk_sessoes_filmes foreign key (idfilme) references filmes(id)
                    );

insert into sessoes(dia,vagas,valorintegral,idsala,idhorario,idfilme) values (date('2014-10-02'),99,15.90,1,1,118340);

create table cadeiras( id int not null
                     , idsala int not null
                     , disponibilidade boolean not null
                     , constraint pk_cadeiras primary key (id, idsala)
                     , constraint fk_cadeiras_salas foreign key (idsala) references salas(id)
                     );

insert into cadeiras values (1,1,false);
insert into cadeiras values (2,1,true);

create table ingressos( id int primary key not null generated always as identity (start with 1, increment by 1)
                      , idsessao int not null
                      , idsala int not null
                      , idcadeira int not null
                      , valorpago real not null
                      , constraint fk_ingressos_sessao foreign key (idsessao) references sessoes(id)
                      , constraint fk_ingressos_salas foreign key (idcadeira, idsala) references cadeiras(id,idsala)
                      );

insert into ingressos(idsessao,idsala,idcadeira,valorpago) values (1,1,1,15.90);

```

<u>Classe de Conexão JDBC:</u>

```java

import java.sql.Connection;
import javax.sql.DataSource;
import org.apache.derby.jdbc.ClientConnectionPoolDataSource;

public class InicializadorBancoDados {
        public static String DB_NAME = "TrabalhoFinal";
        public static String USER_NAME = "usuario";
        public static String PASSWORD = "senha";
        private static DataSource dataSource;

        private static DataSource criarDataSource() throws Exception {
                if (dataSource == null) {
                        ClientConnectionPoolDataSource ds = new ClientConnectionPoolDataSource();
                        ds.setDatabaseName(DB_NAME);
                        ds.setUser(USER_NAME);
                        ds.setPassword(PASSWORD);
                        dataSource = ds;
                }
                return dataSource;
        }

        public static Connection conectarBd() throws Exception {
                return criarDataSource().getConnection();
        }
}

```

##Requisitos

Os seguintes itens são obrigatórios na implementação do sistema:

* Arquitetura multicamada(pelo menos 3).

* Uso dos padrões de projeto explorados em sala de aula, sendo
  obrigatoriamente:
  * Uso do padrão “Facade” para isolar a camada de domínio da camada de
    apresentação;
  * Uso do padrão arquitetural “Domain Model” na camada de domínio;
  * Uso do padrão “DAO” na camada de persistência.

* Interface gráfica de usuário (desktop ou web serão aceitas, interface textual
  de console não será aceita);

* Persistência em banco de dados relacional;

* A camada de persistência deve ser implementada <u>sem a utilização de
  frameworks mapeadores objeto/relacionali</u> (como JPA, Hibernate, etc);

* Tratamento correto do encapsulamento de exceções entre as camadas;

* O banco de dados deverá ter sido previamente populado (um arquivo contendo os
  scripts para geração do BD devem ser entregues juntamente com o código fonte)
  com, no mínimo, os valores necessários para uma boa cobertura dos casos de
  teste.

---

© 2014 Ostrich Informatics.  All rights reserved
