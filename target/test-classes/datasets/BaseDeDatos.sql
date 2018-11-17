-- drop schema public cascade;
-- create schema public;
-- Database: Registro
-- DROP DATABASE "Registro";
-- Table: public.reporteactividades
-- DROP TABLE public.reporteactividades;
-- Table: public.grupos
-- DROP TABLE public.grupos;
-- Table: public.actividades
-- DROP TABLE public.actividades;
-- Table: public.cursos
-- DROP TABLE public.cursos;
-- Table: public.docentes
-- DROP TABLE public.docentes;
-- Table: public.semestres
-- DROP TABLE public.semestres;

CREATE DATABASE "Registro"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Colombia.1252'
    LC_CTYPE = 'Spanish_Colombia.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE TABLE public.actividades
(
    act_id integer NOT NULL,
    act_descripcion character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT actividades_pkey PRIMARY KEY (act_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.actividades
    OWNER to postgres;


CREATE TABLE public.cursos
(
    cur_id integer NOT NULL,
    cur_estado boolean,
    cur_horas integer,
    cur_nombre character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT cursos_pkey PRIMARY KEY (cur_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.cursos
    OWNER to postgres;


CREATE TABLE public.docentes
(
    doce_id integer NOT NULL,
    doce_departamento character varying(255) COLLATE pg_catalog."default",
    doce_email character varying(255) COLLATE pg_catalog."default",
    doce_titulo character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT docentes_pkey PRIMARY KEY (doce_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.docentes
    OWNER to postgres;



CREATE TABLE public.semestres
(
    sem_id integer NOT NULL,
    sem_ano integer,
    sem_estado boolean,
    sem_fechafin date,
    sem_fechainicio date,
    sem_semestre boolean,
    CONSTRAINT semestres_pkey PRIMARY KEY (sem_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.semestres
    OWNER to postgres;


CREATE TABLE public.grupos
(
    gru_id integer NOT NULL,
    gru_cantidadestudiantes integer,
    gru_diaclase character varying(255) COLLATE pg_catalog."default",
    gru_estado boolean,
    gru_fechafin date,
    gru_fechainicio date,
    gru_horafinclase time without time zone,
    gru_horainiclase time without time zone,
    gru_nombre character varying(255) COLLATE pg_catalog."default",
    gru_cur_id integer,
    gru_doce_id integer,
    gru_sem_id integer,
    CONSTRAINT grupos_pkey PRIMARY KEY (gru_id),
    CONSTRAINT fk6siwp34u45ojm134hdwq35uth FOREIGN KEY (gru_sem_id)
        REFERENCES public.semestres (sem_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkf68bxe7v87yapw19tibf2yivx FOREIGN KEY (gru_cur_id)
        REFERENCES public.cursos (cur_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkryjeeg4g1lxgly249baf1hhvp FOREIGN KEY (gru_doce_id)
        REFERENCES public.docentes (doce_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.grupos
    OWNER to postgres;




CREATE TABLE public.reporteactividades
(
    repo_id bigint NOT NULL,
    repo_fecha date,
    repo_horas integer,
    repo_observaciones character varying(255) COLLATE pg_catalog."default",
    repo_act_id integer,
    repo_grupo_id integer,
    CONSTRAINT reporteactividades_pkey PRIMARY KEY (repo_id),
    CONSTRAINT fk4e8i9k0hxn9ip2l33xjjikubo FOREIGN KEY (repo_grupo_id)
        REFERENCES public.grupos (gru_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkh5fpqgpk9wt8mwcommlc1marl FOREIGN KEY (repo_act_id)
        REFERENCES public.actividades (act_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.reporteactividades
    OWNER to postgres;



INSERT INTO public.actividades(
	act_id, act_descripcion)
	VALUES (1, 'Elaboración de plan de trabajo');	
INSERT INTO public.actividades(
	act_id, act_descripcion)
	VALUES (2, 'Clase magistral (Clase virtual, Exposiciones de los estudiantes');
INSERT INTO public.actividades(
	act_id, act_descripcion)
	VALUES (3, 'Resolver talleres');	
INSERT INTO public.actividades(
	act_id, act_descripcion)
	VALUES (4, 'Realizar examenes.');
INSERT INTO public.actividades(
	act_id, act_descripcion)
	VALUES (5, 'Calificación de examenes');
INSERT INTO public.actividades(
	act_id, act_descripcion)
	VALUES (6, 'Presentar notas');	
INSERT INTO public.actividades(
	act_id, act_descripcion)
	VALUES (7, 'Acompañamiento de trabajos, grupos de investigación');
INSERT INTO public.actividades(
	act_id, act_descripcion)
	VALUES (8, 'Tutorias, asesorias');

INSERT INTO public.cursos(
	cur_id, cur_estado, cur_horas, cur_nombre)
	VALUES (1, TRUE, 98, 'Matematicas Discretas 1');
INSERT INTO public.cursos(
	cur_id, cur_estado, cur_horas, cur_nombre)
	VALUES (2, TRUE, 98, 'Fisica 1');
INSERT INTO public.cursos(
	cur_id, cur_estado, cur_horas, cur_nombre)
	VALUES (3, FALSE, 98, 'Fisica 2');
INSERT INTO public.cursos(
	cur_id, cur_estado, cur_horas, cur_nombre)
	VALUES (4, FALSE, 98, 'Matematicas Discretas 2');

INSERT INTO public.semestres(
	sem_id, sem_ano, sem_estado, sem_fechafin, sem_fechainicio, sem_semestre)
	VALUES (2, 2018, TRUE, '2018-11-01', '2018-07-01', TRUE);
INSERT INTO public.semestres(
	sem_id, sem_ano, sem_estado, sem_fechafin, sem_fechainicio, sem_semestre)
	VALUES (1, 2018, TRUE, '2018-02-01', '2018-06-15', FALSE);	
	

INSERT INTO public.docentes(
	doce_id,doce_email, doce_departamento, doce_titulo)
	VALUES (71701882,'andres@udea.edu.co', 'Matemáticas', 'Matemático');
INSERT INTO public.docentes(
	doce_id,doce_email, doce_departamento, doce_titulo)
	VALUES (1001234509,'sebastian@udea.edu.co', 'Ingeniería de Sistemas', 'Ingeniero de Sistemas');
INSERT INTO public.docentes(
	doce_id,doce_email, doce_departamento, doce_titulo)
	VALUES (1011254510,'carlos@udea.edu.co', 'Física', 'Físico');


INSERT INTO public.grupos(
	gru_id, gru_cantidadestudiantes, gru_diaclase, gru_estado, gru_fechafin, gru_fechainicio, gru_horafinclase, gru_horainiclase, gru_nombre, gru_cur_id, gru_doce_id, gru_sem_id)
	VALUES (1, 15, 'Ma-Jue', TRUE, '2018-11-01', '2018-07-01', '08:00:00', '06:00:00', 'Física 1-Grupo01', 2, 1011254510, 2);
INSERT INTO public.grupos(
	gru_id, gru_cantidadestudiantes, gru_diaclase, gru_estado, gru_fechafin, gru_fechainicio, gru_horafinclase, gru_horainiclase, gru_nombre, gru_cur_id, gru_doce_id, gru_sem_id)
	VALUES (2, 20, 'Lu-Mie', TRUE, '2018-11-01', '2018-07-01', '10:00:00', '08:00:00', 'Matematica Disc 1-Grupo02', 4, 71701882, 2);
INSERT INTO public.grupos(
	gru_id, gru_cantidadestudiantes, gru_diaclase, gru_estado, gru_fechafin, gru_fechainicio, gru_horafinclase, gru_horainiclase, gru_nombre, gru_cur_id, gru_doce_id, gru_sem_id)
	VALUES (3, 20, 'Ma-Jue', TRUE, '2018-11-01', '2018-07-01', '14:00:00', '12:00:00', 'Matematica Disc 1-Grupo03', 1, 71701882, 2);
INSERT INTO public.grupos(
	gru_id, gru_cantidadestudiantes, gru_diaclase, gru_estado, gru_fechafin, gru_fechainicio, gru_horafinclase, gru_horainiclase, gru_nombre, gru_cur_id, gru_doce_id, gru_sem_id)
	VALUES (4, 20, 'Lu-Sab', FALSE, '2018-11-01', '2018-07-01', '18:00:00', '16:00:00', 'Matematica Disc 2-Grupo03', 4, 71701882, 1);
	

