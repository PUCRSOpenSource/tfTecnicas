drop table ingressos;
drop table cadeiras;
drop table sessoes;
drop table filmes;
drop table salas;
drop table horarios;

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
                     , idsessao int not null
                     , disponibilidade boolean not null
                     , constraint pk_cadeiras primary key (id, idsessao)
                     , constraint fk_cadeiras_salas foreign key (idsessao) references sessoes(id)
                     );

insert into cadeiras values (1,1,false);
insert into cadeiras values (2,1,true);

create table ingressos( id int primary key not null generated always as identity (start with 1, increment by 1)
                      , idsessao int not null
                      , idcadeira int not null
                      , valorpago real not null
                      , constraint fk_ingressos_salas foreign key (idcadeira, idsessao) references cadeiras(id,idsessao)
                      );

insert into ingressos(idsessao,idcadeira,valorpago) values (1,1,15.90);