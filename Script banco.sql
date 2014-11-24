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

insert into horarios values (1,'10:00','12:00');
insert into horarios values (2,'11:00','13:15');
insert into horarios values (3,'14:00','16:00');
insert into horarios values (4,'15:00','17:30');
insert into horarios values (5,'17:00','19:00');
insert into horarios values (6,'18:00','20:20');
insert into horarios values (7,'19:00','21:00');
insert into horarios values (8,'20:30','23:00');
insert into horarios values (9,'21:00','23:00');
insert into horarios values (10,'22:00','24:00');

create table salas( id int primary key not null
                  , capacidade int not null
                  );

insert into salas values (1, 100);
insert into salas values (2, 100);
insert into salas values (3, 100);

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
insert into sessoes(dia,vagas,valorintegral,idsala,idhorario,idfilme) values (date('2014-10-02'),1,15.90,1,9,118340);
insert into sessoes(dia,vagas,valorintegral,idsala,idhorario,idfilme) values (date('2014-10-02'),55,15.90,1,5,118340);



create table cadeiras( id int not null
                     , idsessao int not null
                     , disponibilidade boolean not null
                     , constraint pk_cadeiras primary key (id, idsessao)
                     , constraint fk_cadeiras_salas foreign key (idsessao) references sessoes(id)
                     );

insert into cadeiras values (1,1,true);
insert into cadeiras values (2,1,false);
insert into cadeiras values (3,1,true);
insert into cadeiras values (4,1,true);
insert into cadeiras values (5,1,true);
insert into cadeiras values (6,1,true);
insert into cadeiras values (7,1,true);
insert into cadeiras values (8,1,true);
insert into cadeiras values (9,1,true);
insert into cadeiras values (10,1,true);
insert into cadeiras values (11,1,true);
insert into cadeiras values (12,1,true);
insert into cadeiras values (13,1,true);
insert into cadeiras values (14,1,true);
insert into cadeiras values (15,1,true);
insert into cadeiras values (16,1,true);
insert into cadeiras values (17,1,true);
insert into cadeiras values (18,1,true);
insert into cadeiras values (19,1,true);
insert into cadeiras values (20,1,true);
insert into cadeiras values (21,1,true);
insert into cadeiras values (22,1,true);
insert into cadeiras values (23,1,true);
insert into cadeiras values (24,1,true);
insert into cadeiras values (25,1,true);
insert into cadeiras values (26,1,true);
insert into cadeiras values (27,1,true);
insert into cadeiras values (28,1,true);
insert into cadeiras values (29,1,true);
insert into cadeiras values (30,1,true);
insert into cadeiras values (31,1,true);
insert into cadeiras values (32,1,true);
insert into cadeiras values (33,1,true);
insert into cadeiras values (34,1,true);
insert into cadeiras values (35,1,true);
insert into cadeiras values (36,1,true);
insert into cadeiras values (37,1,true);
insert into cadeiras values (38,1,true);
insert into cadeiras values (39,1,true);
insert into cadeiras values (40,1,true);
insert into cadeiras values (41,1,true);
insert into cadeiras values (42,1,true);
insert into cadeiras values (43,1,true);
insert into cadeiras values (44,1,true);
insert into cadeiras values (45,1,true);
insert into cadeiras values (46,1,true);
insert into cadeiras values (47,1,true);
insert into cadeiras values (48,1,true);
insert into cadeiras values (49,1,true);
insert into cadeiras values (50,1,true);
insert into cadeiras values (51,1,true);
insert into cadeiras values (52,1,true);
insert into cadeiras values (53,1,true);
insert into cadeiras values (54,1,true);
insert into cadeiras values (55,1,true);
insert into cadeiras values (56,1,true);
insert into cadeiras values (57,1,true);
insert into cadeiras values (58,1,true);
insert into cadeiras values (59,1,true);
insert into cadeiras values (60,1,true);
insert into cadeiras values (61,1,true);
insert into cadeiras values (62,1,true);
insert into cadeiras values (63,1,true);
insert into cadeiras values (64,1,true);
insert into cadeiras values (65,1,true);
insert into cadeiras values (66,1,true);
insert into cadeiras values (67,1,true);
insert into cadeiras values (68,1,true);
insert into cadeiras values (69,1,true);
insert into cadeiras values (70,1,true);
insert into cadeiras values (71,1,true);
insert into cadeiras values (72,1,true);
insert into cadeiras values (73,1,true);
insert into cadeiras values (74,1,true);
insert into cadeiras values (75,1,true);
insert into cadeiras values (76,1,true);
insert into cadeiras values (77,1,true);
insert into cadeiras values (78,1,true);
insert into cadeiras values (79,1,true);
insert into cadeiras values (80,1,true);
insert into cadeiras values (81,1,true);
insert into cadeiras values (82,1,true);
insert into cadeiras values (83,1,true);
insert into cadeiras values (84,1,true);
insert into cadeiras values (85,1,true);
insert into cadeiras values (86,1,true);
insert into cadeiras values (87,1,true);
insert into cadeiras values (88,1,true);
insert into cadeiras values (89,1,true);
insert into cadeiras values (90,1,true);
insert into cadeiras values (91,1,true);
insert into cadeiras values (92,1,true);
insert into cadeiras values (93,1,true);
insert into cadeiras values (94,1,true);
insert into cadeiras values (95,1,true);
insert into cadeiras values (96,1,true);
insert into cadeiras values (97,1,true);
insert into cadeiras values (98,1,true);
insert into cadeiras values (99,1,true);
insert into cadeiras values (100,1,true);


insert into cadeiras values (1,2,true);
insert into cadeiras values (2,2,false);
insert into cadeiras values (3,2,false);
insert into cadeiras values (4,2,false);
insert into cadeiras values (5,2,false);
insert into cadeiras values (6,2,false);
insert into cadeiras values (7,2,false);
insert into cadeiras values (8,2,false);
insert into cadeiras values (9,2,false);
insert into cadeiras values (10,2,false);
insert into cadeiras values (11,2,false);
insert into cadeiras values (12,2,false);
insert into cadeiras values (13,2,false);
insert into cadeiras values (14,2,false);
insert into cadeiras values (15,2,false);
insert into cadeiras values (16,2,false);
insert into cadeiras values (17,2,false);
insert into cadeiras values (18,2,false);
insert into cadeiras values (19,2,false);
insert into cadeiras values (20,2,false);
insert into cadeiras values (21,2,false);
insert into cadeiras values (22,2,false);
insert into cadeiras values (23,2,false);
insert into cadeiras values (24,2,false);
insert into cadeiras values (25,2,false);
insert into cadeiras values (26,2,false);
insert into cadeiras values (27,2,false);
insert into cadeiras values (28,2,false);
insert into cadeiras values (29,2,false);
insert into cadeiras values (30,2,false);
insert into cadeiras values (31,2,false);
insert into cadeiras values (32,2,false);
insert into cadeiras values (33,2,false);
insert into cadeiras values (34,2,false);
insert into cadeiras values (35,2,false);
insert into cadeiras values (36,2,false);
insert into cadeiras values (37,2,false);
insert into cadeiras values (38,2,false);
insert into cadeiras values (39,2,false);
insert into cadeiras values (40,2,false);
insert into cadeiras values (41,2,false);
insert into cadeiras values (42,2,false);
insert into cadeiras values (43,2,false);
insert into cadeiras values (44,2,false);
insert into cadeiras values (45,2,false);
insert into cadeiras values (46,2,false);
insert into cadeiras values (47,2,false);
insert into cadeiras values (48,2,false);
insert into cadeiras values (49,2,false);
insert into cadeiras values (50,2,false);
insert into cadeiras values (51,2,false);
insert into cadeiras values (52,2,false);
insert into cadeiras values (53,2,false);
insert into cadeiras values (54,2,false);
insert into cadeiras values (55,2,false);
insert into cadeiras values (56,2,false);
insert into cadeiras values (57,2,false);
insert into cadeiras values (58,2,false);
insert into cadeiras values (59,2,false);
insert into cadeiras values (60,2,false);
insert into cadeiras values (61,2,false);
insert into cadeiras values (62,2,false);
insert into cadeiras values (63,2,false);
insert into cadeiras values (64,2,false);
insert into cadeiras values (65,2,false);
insert into cadeiras values (66,2,false);
insert into cadeiras values (67,2,false);
insert into cadeiras values (68,2,false);
insert into cadeiras values (69,2,false);
insert into cadeiras values (70,2,false);
insert into cadeiras values (71,2,false);
insert into cadeiras values (72,2,false);
insert into cadeiras values (73,2,false);
insert into cadeiras values (74,2,false);
insert into cadeiras values (75,2,false);
insert into cadeiras values (76,2,false);
insert into cadeiras values (77,2,false);
insert into cadeiras values (78,2,false);
insert into cadeiras values (79,2,false);
insert into cadeiras values (80,2,false);
insert into cadeiras values (81,2,false);
insert into cadeiras values (82,2,false);
insert into cadeiras values (83,2,false);
insert into cadeiras values (84,2,false);
insert into cadeiras values (85,2,false);
insert into cadeiras values (86,2,false);
insert into cadeiras values (87,2,false);
insert into cadeiras values (88,2,false);
insert into cadeiras values (89,2,false);
insert into cadeiras values (90,2,false);
insert into cadeiras values (91,2,false);
insert into cadeiras values (92,2,false);
insert into cadeiras values (93,2,false);
insert into cadeiras values (94,2,false);
insert into cadeiras values (95,2,false);
insert into cadeiras values (96,2,false);
insert into cadeiras values (97,2,false);
insert into cadeiras values (98,2,false);
insert into cadeiras values (99,2,false);
insert into cadeiras values (100,2,false);


insert into cadeiras values (1,3,true);
insert into cadeiras values (2,3,true);
insert into cadeiras values (3,3,true);
insert into cadeiras values (4,3,true);
insert into cadeiras values (5,3,true);
insert into cadeiras values (6,3,true);
insert into cadeiras values (7,3,true);
insert into cadeiras values (8,3,true);
insert into cadeiras values (9,3,true);
insert into cadeiras values (10,3,true);
insert into cadeiras values (11,3,true);
insert into cadeiras values (12,3,true);
insert into cadeiras values (13,3,true);
insert into cadeiras values (14,3,true);
insert into cadeiras values (15,3,true);
insert into cadeiras values (16,3,true);
insert into cadeiras values (17,3,true);
insert into cadeiras values (18,3,true);
insert into cadeiras values (19,3,true);
insert into cadeiras values (20,3,true);
insert into cadeiras values (21,3,true);
insert into cadeiras values (22,3,true);
insert into cadeiras values (23,3,true);
insert into cadeiras values (24,3,true);
insert into cadeiras values (25,3,true);
insert into cadeiras values (26,3,true);
insert into cadeiras values (27,3,true);
insert into cadeiras values (28,3,true);
insert into cadeiras values (29,3,true);
insert into cadeiras values (30,3,true);
insert into cadeiras values (31,3,true);
insert into cadeiras values (32,3,true);
insert into cadeiras values (33,3,true);
insert into cadeiras values (34,3,true);
insert into cadeiras values (35,3,true);
insert into cadeiras values (36,3,true);
insert into cadeiras values (37,3,true);
insert into cadeiras values (38,3,true);
insert into cadeiras values (39,3,true);
insert into cadeiras values (40,3,true);
insert into cadeiras values (41,3,true);
insert into cadeiras values (42,3,true);
insert into cadeiras values (43,3,true);
insert into cadeiras values (44,3,true);
insert into cadeiras values (45,3,true);
insert into cadeiras values (46,3,true);
insert into cadeiras values (47,3,true);
insert into cadeiras values (48,3,true);
insert into cadeiras values (49,3,true);
insert into cadeiras values (50,3,true);
insert into cadeiras values (51,3,true);
insert into cadeiras values (52,3,true);
insert into cadeiras values (53,3,true);
insert into cadeiras values (54,3,true);
insert into cadeiras values (55,3,true);
insert into cadeiras values (56,3,false);
insert into cadeiras values (57,3,false);
insert into cadeiras values (58,3,false);
insert into cadeiras values (59,3,false);
insert into cadeiras values (60,3,false);
insert into cadeiras values (61,3,false);
insert into cadeiras values (62,3,false);
insert into cadeiras values (63,3,false);
insert into cadeiras values (64,3,false);
insert into cadeiras values (65,3,false);
insert into cadeiras values (66,3,false);
insert into cadeiras values (67,3,false);
insert into cadeiras values (68,3,false);
insert into cadeiras values (69,3,false);
insert into cadeiras values (70,3,false);
insert into cadeiras values (71,3,false);
insert into cadeiras values (72,3,false);
insert into cadeiras values (73,3,false);
insert into cadeiras values (74,3,false);
insert into cadeiras values (75,3,false);
insert into cadeiras values (76,3,false);
insert into cadeiras values (77,3,false);
insert into cadeiras values (78,3,false);
insert into cadeiras values (79,3,false);
insert into cadeiras values (80,3,false);
insert into cadeiras values (81,3,false);
insert into cadeiras values (82,3,false);
insert into cadeiras values (83,3,false);
insert into cadeiras values (84,3,false);
insert into cadeiras values (85,3,false);
insert into cadeiras values (86,3,false);
insert into cadeiras values (87,3,false);
insert into cadeiras values (88,3,false);
insert into cadeiras values (89,3,false);
insert into cadeiras values (90,3,false);
insert into cadeiras values (91,3,false);
insert into cadeiras values (92,3,false);
insert into cadeiras values (93,3,false);
insert into cadeiras values (94,3,false);
insert into cadeiras values (95,3,false);
insert into cadeiras values (96,3,false);
insert into cadeiras values (97,3,false);
insert into cadeiras values (98,3,false);
insert into cadeiras values (99,3,false);
insert into cadeiras values (100,3,false);

create table ingressos( id int primary key not null generated always as identity (start with 1, increment by 1)
                      , idsessao int not null
                      , idcadeira int not null
                      , valorpago real not null
                      , constraint fk_ingressos_salas foreign key (idcadeira, idsessao) references cadeiras(id,idsessao)
                      );

insert into ingressos(idsessao,idcadeira,valorpago) values (1,2,15.90);


insert into ingressos(idsessao,idcadeira,valorpago) values (2,2,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,3,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,4,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,5,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,6,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,7,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,8,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,9,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,10,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,11,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,12,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,13,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,14,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,15,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,16,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,17,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,18,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,19,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,20,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,21,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,22,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,23,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,24,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,25,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,26,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,27,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,28,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,29,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,30,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,31,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,32,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,33,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,34,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,35,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,36,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,37,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,38,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,39,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,40,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,41,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,42,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,43,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,44,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,45,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,46,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,47,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,48,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,49,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,50,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,51,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,52,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,53,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,54,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,55,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,56,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,57,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,58,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,59,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,60,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,61,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,62,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,63,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,64,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,65,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,66,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,67,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,68,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,69,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,70,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,71,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,72,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,73,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,74,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,75,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,76,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,77,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,78,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,79,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,80,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,81,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,82,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,83,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,84,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,85,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,86,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,87,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,88,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,89,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,90,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,91,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,92,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,93,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,94,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,95,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,96,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,97,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,98,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,99,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (2,100,15.90);


insert into ingressos(idsessao,idcadeira,valorpago) values (3,56,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,57,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,58,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,59,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,60,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,61,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,62,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,63,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,64,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,65,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,66,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,67,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,68,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,69,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,70,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,71,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,72,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,73,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,74,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,75,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,76,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,77,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,78,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,79,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,80,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,81,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,82,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,83,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,84,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,85,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,86,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,87,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,88,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,89,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,90,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,91,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,92,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,93,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,94,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,95,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,96,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,97,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,98,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,99,15.90);
insert into ingressos(idsessao,idcadeira,valorpago) values (3,100,15.90);
