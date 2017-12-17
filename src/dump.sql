--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.10
-- Dumped by pg_dump version 9.5.10

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: nc-task; Type: SCHEMA; Schema: -; Owner: typhoon
--

CREATE SCHEMA "nc-task";


ALTER SCHEMA "nc-task" OWNER TO typhoon;

SET search_path = "nc-task", pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: company; Type: TABLE; Schema: nc-task; Owner: typhoon
--

CREATE TABLE company (
    name character varying(64) NOT NULL
);


ALTER TABLE company OWNER TO typhoon;

--
-- Name: employees; Type: TABLE; Schema: nc-task; Owner: typhoon
--

CREATE TABLE employees (
    empid integer NOT NULL,
    name character varying(64) NOT NULL,
    department character varying(64)
);


ALTER TABLE employees OWNER TO typhoon;

--
-- Name: employees_empid_seq; Type: SEQUENCE; Schema: nc-task; Owner: typhoon
--

CREATE SEQUENCE employees_empid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE employees_empid_seq OWNER TO typhoon;

--
-- Name: employees_empid_seq; Type: SEQUENCE OWNED BY; Schema: nc-task; Owner: typhoon
--

ALTER SEQUENCE employees_empid_seq OWNED BY employees.empid;


--
-- Name: emptoproject; Type: TABLE; Schema: nc-task; Owner: typhoon
--

CREATE TABLE emptoproject (
    empid integer NOT NULL,
    name character varying(64) NOT NULL
);


ALTER TABLE emptoproject OWNER TO typhoon;

--
-- Name: project; Type: TABLE; Schema: nc-task; Owner: typhoon
--

CREATE TABLE project (
    name character varying(64) NOT NULL,
    company character varying(64),
    managerid integer
);


ALTER TABLE project OWNER TO typhoon;

--
-- Name: empid; Type: DEFAULT; Schema: nc-task; Owner: typhoon
--

ALTER TABLE ONLY employees ALTER COLUMN empid SET DEFAULT nextval('employees_empid_seq'::regclass);


--
-- Data for Name: company; Type: TABLE DATA; Schema: nc-task; Owner: typhoon
--

INSERT INTO company (name) VALUES ('google');
INSERT INTO company (name) VALUES ('vk.com');
INSERT INTO company (name) VALUES ('twitter');


--
-- Data for Name: employees; Type: TABLE DATA; Schema: nc-task; Owner: typhoon
--

INSERT INTO employees (empid, name, department) VALUES (13, 'Petrov', 'HR');
INSERT INTO employees (empid, name, department) VALUES (14, 'Sidorov', 'HR');
INSERT INTO employees (empid, name, department) VALUES (15, 'Ivanov', 'Development');
INSERT INTO employees (empid, name, department) VALUES (16, 'Smirnov', 'Development');


--
-- Name: employees_empid_seq; Type: SEQUENCE SET; Schema: nc-task; Owner: typhoon
--

SELECT pg_catalog.setval('employees_empid_seq', 18, true);


--
-- Data for Name: emptoproject; Type: TABLE DATA; Schema: nc-task; Owner: typhoon
--

INSERT INTO emptoproject (empid, name) VALUES (13, 'bootstrap');
INSERT INTO emptoproject (empid, name) VALUES (14, 'vk');
INSERT INTO emptoproject (empid, name) VALUES (15, 'maps');
INSERT INTO emptoproject (empid, name) VALUES (16, 'vk');
INSERT INTO emptoproject (empid, name) VALUES (16, 'maps');


--
-- Data for Name: project; Type: TABLE DATA; Schema: nc-task; Owner: typhoon
--

INSERT INTO project (name, company, managerid) VALUES ('vk', 'vk.com', 16);
INSERT INTO project (name, company, managerid) VALUES ('maps', 'google', 15);
INSERT INTO project (name, company, managerid) VALUES ('bootstrap', 'twitter', NULL);


--
-- Name: company_pkey; Type: CONSTRAINT; Schema: nc-task; Owner: typhoon
--

ALTER TABLE ONLY company
    ADD CONSTRAINT company_pkey PRIMARY KEY (name);


--
-- Name: employees_pkey; Type: CONSTRAINT; Schema: nc-task; Owner: typhoon
--

ALTER TABLE ONLY employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (empid);


--
-- Name: emptoproject_pk; Type: CONSTRAINT; Schema: nc-task; Owner: typhoon
--

ALTER TABLE ONLY emptoproject
    ADD CONSTRAINT emptoproject_pk PRIMARY KEY (empid, name);


--
-- Name: project_pkey; Type: CONSTRAINT; Schema: nc-task; Owner: typhoon
--

ALTER TABLE ONLY project
    ADD CONSTRAINT project_pkey PRIMARY KEY (name);


--
-- Name: emptoproject_employees_empid_fk; Type: FK CONSTRAINT; Schema: nc-task; Owner: typhoon
--

ALTER TABLE ONLY emptoproject
    ADD CONSTRAINT emptoproject_employees_empid_fk FOREIGN KEY (empid) REFERENCES employees(empid);


--
-- Name: emptoproject_project_fk; Type: FK CONSTRAINT; Schema: nc-task; Owner: typhoon
--

ALTER TABLE ONLY emptoproject
    ADD CONSTRAINT emptoproject_project_fk FOREIGN KEY (name) REFERENCES project(name);


--
-- Name: project_company_fk; Type: FK CONSTRAINT; Schema: nc-task; Owner: typhoon
--

ALTER TABLE ONLY project
    ADD CONSTRAINT project_company_fk FOREIGN KEY (company) REFERENCES company(name);


--
-- Name: project_manager_fk; Type: FK CONSTRAINT; Schema: nc-task; Owner: typhoon
--

ALTER TABLE ONLY project
    ADD CONSTRAINT project_manager_fk FOREIGN KEY (managerid) REFERENCES employees(empid);


--
-- PostgreSQL database dump complete
--

