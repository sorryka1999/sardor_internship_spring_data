--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

-- Started on 2022-07-22 16:35:19

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

--
-- TOC entry 3323 (class 1262 OID 16611)
-- Name: sardor_internship; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE sardor_internship WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1252';


ALTER DATABASE sardor_internship OWNER TO postgres;

\connect sardor_internship

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
-- TOC entry 3325 (class 0 OID 0)
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
-- TOC entry 3326 (class 0 OID 0)
-- Dependencies: 209
-- Name: interns_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.interns_id_seq OWNED BY public.interns.id;


--
-- TOC entry 3170 (class 2604 OID 16623)
-- Name: employees id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees ALTER COLUMN id SET DEFAULT nextval('public.employees_id_seq'::regclass);


--
-- TOC entry 3169 (class 2604 OID 16616)
-- Name: interns id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.interns ALTER COLUMN id SET DEFAULT nextval('public.interns_id_seq'::regclass);


--
-- TOC entry 3317 (class 0 OID 16620)
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
-- TOC entry 3315 (class 0 OID 16613)
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
-- TOC entry 3327 (class 0 OID 0)
-- Dependencies: 211
-- Name: employees_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employees_id_seq', 6, true);


--
-- TOC entry 3328 (class 0 OID 0)
-- Dependencies: 209
-- Name: interns_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.interns_id_seq', 6, true);


--
-- TOC entry 3174 (class 2606 OID 16625)
-- Name: employees employees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (id);


--
-- TOC entry 3172 (class 2606 OID 16618)
-- Name: interns interns_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.interns
    ADD CONSTRAINT interns_pkey PRIMARY KEY (id);


--
-- TOC entry 3324 (class 0 OID 0)
-- Dependencies: 3323
-- Name: DATABASE sardor_internship; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON DATABASE sardor_internship TO sardor;


-- Completed on 2022-07-22 16:35:19

--
-- PostgreSQL database dump complete
--

