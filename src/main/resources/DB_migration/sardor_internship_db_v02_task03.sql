--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

-- Started on 2022-07-30 01:42:03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 212 (class 1259 OID 16620)
-- Name: employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employees (
    id integer NOT NULL,
    name character varying(32) NOT NULL,
    surname character varying(32) NOT NULL,
    "position" character varying(128) NOT NULL
);


ALTER TABLE public.employees OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 16619)
-- Name: employees_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.employees_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employees_id_seq OWNER TO postgres;

--
-- TOC entry 3346 (class 0 OID 0)
-- Dependencies: 211
-- Name: employees_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.employees_id_seq OWNED BY public.employees.id;


--
-- TOC entry 210 (class 1259 OID 16613)
-- Name: interns; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.interns (
    id integer NOT NULL,
    name character varying(32) NOT NULL,
    surname character varying(32) NOT NULL,
    age integer NOT NULL,
    hobby character varying(64) NOT NULL
);


ALTER TABLE public.interns OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16612)
-- Name: interns_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.interns_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.interns_id_seq OWNER TO postgres;

--
-- TOC entry 3347 (class 0 OID 0)
-- Dependencies: 209
-- Name: interns_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.interns_id_seq OWNED BY public.interns.id;


--
-- TOC entry 214 (class 1259 OID 16627)
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
    id integer NOT NULL,
    role character varying(32) NOT NULL,
    name character varying(32) NOT NULL
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 16626)
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_seq OWNER TO postgres;

--
-- TOC entry 3348 (class 0 OID 0)
-- Dependencies: 213
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;


--
-- TOC entry 216 (class 1259 OID 16634)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    name character varying(64) NOT NULL,
    surname character varying(64) NOT NULL,
    age integer NOT NULL,
    email character varying(256) NOT NULL,
    password character varying(256) NOT NULL,
    role_id bigint NOT NULL,
    isactive boolean NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16633)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 3349 (class 0 OID 0)
-- Dependencies: 215
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 3180 (class 2604 OID 16623)
-- Name: employees id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees ALTER COLUMN id SET DEFAULT nextval('public.employees_id_seq'::regclass);


--
-- TOC entry 3179 (class 2604 OID 16616)
-- Name: interns id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.interns ALTER COLUMN id SET DEFAULT nextval('public.interns_id_seq'::regclass);


--
-- TOC entry 3181 (class 2604 OID 16630)
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);


--
-- TOC entry 3182 (class 2604 OID 16637)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 3336 (class 0 OID 16620)
-- Dependencies: 212
-- Data for Name: employees; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.employees VALUES (1, 'Sardor', 'Khurramov', 'Intern in Enterprise Data Management');
INSERT INTO public.employees VALUES (2, 'Firdavs', 'Fozilov', 'Intern in Enterprise Data Management');
INSERT INTO public.employees VALUES (3, 'Abrorxon', 'Pulotxonov', 'Intern in Enterprise Data Management');
INSERT INTO public.employees VALUES (4, 'Gayrat', 'Sadykov', 'Intern in Enterprise Data Management');
INSERT INTO public.employees VALUES (5, 'Nurmuhammad', 'Maxmudov', 'Intern in Enterprise Data Management');
INSERT INTO public.employees VALUES (6, 'Suxrob', 'Normurodov', 'Intern in Enterprise Data Management');


--
-- TOC entry 3334 (class 0 OID 16613)
-- Dependencies: 210
-- Data for Name: interns; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.interns VALUES (1, 'Sardor', 'Khurramov', 23, 'tennis');
INSERT INTO public.interns VALUES (2, 'Firdavs', 'Fozilov', 23, 'swimming');
INSERT INTO public.interns VALUES (3, 'Abrorxon', 'Pulotxonov', 23, 'football');
INSERT INTO public.interns VALUES (4, 'Gayrat', 'Sadykov', 23, 'box');
INSERT INTO public.interns VALUES (5, 'Nurmuhammad', 'Maxmudov', 23, 'table tennis');
INSERT INTO public.interns VALUES (6, 'Suxrob', 'Normurodov', 23, 'football');


--
-- TOC entry 3338 (class 0 OID 16627)
-- Dependencies: 214
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.roles VALUES (1, 'admin', 'администратор');
INSERT INTO public.roles VALUES (2, 'manager', 'менеджер');
INSERT INTO public.roles VALUES (3, 'mentor', 'ментор');


--
-- TOC entry 3340 (class 0 OID 16634)
-- Dependencies: 216
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users VALUES (7, 'Sardor', 'Khurramov', 23, 'sardor.mentor@megafon.ru', '$2a$10$4bVGGtvNiJB1bEErRDuoKuBT7JlNq0XUsLSTM8A8YwRAEh0AMpfPi', 3, true);
INSERT INTO public.users VALUES (9, 'Sardor', 'Khurramov', 23, 'sardor.admin@megafon.ru', '$2a$10$GCoEoplOiyraDzVA41No3ujPqgclqhu2rQYUpSjE2xjjWNB3ORT0q', 1, true);
INSERT INTO public.users VALUES (8, 'Sardor', 'Khurramov', 23, 'sardor.manager@megafon.ru', '$2a$10$GghzaHFRO4q8IOfUF.uhn.JhtIMQpwiusLkMSqcFE5dIXYs/wZhUe', 2, true);


--
-- TOC entry 3350 (class 0 OID 0)
-- Dependencies: 211
-- Name: employees_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employees_id_seq', 6, true);


--
-- TOC entry 3351 (class 0 OID 0)
-- Dependencies: 209
-- Name: interns_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.interns_id_seq', 6, true);


--
-- TOC entry 3352 (class 0 OID 0)
-- Dependencies: 213
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.roles_id_seq', 3, true);


--
-- TOC entry 3353 (class 0 OID 0)
-- Dependencies: 215
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 9, true);


--
-- TOC entry 3186 (class 2606 OID 16625)
-- Name: employees employees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (id);


--
-- TOC entry 3184 (class 2606 OID 16618)
-- Name: interns interns_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.interns
    ADD CONSTRAINT interns_pkey PRIMARY KEY (id);


--
-- TOC entry 3188 (class 2606 OID 16632)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- TOC entry 3190 (class 2606 OID 16643)
-- Name: users unique_email; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT unique_email UNIQUE (email);


--
-- TOC entry 3192 (class 2606 OID 16641)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 3193 (class 2606 OID 16644)
-- Name: users role_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT role_id_fkey FOREIGN KEY (role_id) REFERENCES public.roles(id) ON UPDATE CASCADE ON DELETE RESTRICT;


-- Completed on 2022-07-30 01:42:06

--
-- PostgreSQL database dump complete
--

