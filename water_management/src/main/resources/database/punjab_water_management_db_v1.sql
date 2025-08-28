--
-- PostgreSQL database dump
--

\restrict ld9Duh8awo9mIWU9TnGRTcfhlDUc2pKyW7fsqf8ViGsjgYgwRfahXKcKv9LZcha

-- Dumped from database version 17.6
-- Dumped by pg_dump version 17.6

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: postgis; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS postgis WITH SCHEMA public;


--
-- Name: EXTENSION postgis; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION postgis IS 'PostGIS geometry and geography spatial types and functions';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: crop; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.crop (
    crop_id integer NOT NULL,
    crop_name character varying(100) NOT NULL,
    crop_type character varying(100)
);


ALTER TABLE public.crop OWNER TO postgres;

--
-- Name: crop_crop_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.crop_crop_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.crop_crop_id_seq OWNER TO postgres;

--
-- Name: crop_crop_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.crop_crop_id_seq OWNED BY public.crop.crop_id;


--
-- Name: district; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.district (
    district_id integer NOT NULL,
    district_name character varying(500) NOT NULL,
    division_id integer,
    district_name_ur character varying(500)
);


ALTER TABLE public.district OWNER TO postgres;

--
-- Name: district_district_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.district_district_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.district_district_id_seq OWNER TO postgres;

--
-- Name: district_district_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.district_district_id_seq OWNED BY public.district.district_id;


--
-- Name: division; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.division (
    id integer NOT NULL,
    division_name character varying(500) NOT NULL,
    division_name_ur character varying(500) NOT NULL
);


ALTER TABLE public.division OWNER TO postgres;

--
-- Name: farmer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.farmer (
    farmer_id integer NOT NULL,
    name character varying(150) NOT NULL,
    cnic character varying(15) NOT NULL,
    phone character varying(20),
    address text,
    uc_id integer NOT NULL
);


ALTER TABLE public.farmer OWNER TO postgres;

--
-- Name: farmer_farmer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.farmer_farmer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.farmer_farmer_id_seq OWNER TO postgres;

--
-- Name: farmer_farmer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.farmer_farmer_id_seq OWNED BY public.farmer.farmer_id;


--
-- Name: farmer_water_report; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.farmer_water_report (
    report_id integer NOT NULL,
    farmer_id integer NOT NULL,
    uc_id integer NOT NULL,
    terrain_id integer NOT NULL,
    season_id integer NOT NULL,
    wish_crop_id integer,
    generated_on timestamp without time zone DEFAULT now(),
    notes text
);


ALTER TABLE public.farmer_water_report OWNER TO postgres;

--
-- Name: farmer_water_report_report_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.farmer_water_report_report_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.farmer_water_report_report_id_seq OWNER TO postgres;

--
-- Name: farmer_water_report_report_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.farmer_water_report_report_id_seq OWNED BY public.farmer_water_report.report_id;


--
-- Name: recommended_crops_report; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.recommended_crops_report (
    rec_id integer NOT NULL,
    report_id integer NOT NULL,
    crop_id integer NOT NULL,
    reason text,
    notes text
);


ALTER TABLE public.recommended_crops_report OWNER TO postgres;

--
-- Name: recommended_crops_report_rec_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.recommended_crops_report_rec_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.recommended_crops_report_rec_id_seq OWNER TO postgres;

--
-- Name: recommended_crops_report_rec_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.recommended_crops_report_rec_id_seq OWNED BY public.recommended_crops_report.rec_id;


--
-- Name: season; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.season (
    season_id integer NOT NULL,
    season_name character varying(100) NOT NULL,
    start_month character varying(20),
    end_month character varying(20)
);


ALTER TABLE public.season OWNER TO postgres;

--
-- Name: season_season_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.season_season_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.season_season_id_seq OWNER TO postgres;

--
-- Name: season_season_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.season_season_id_seq OWNED BY public.season.season_id;


--
-- Name: tehsil; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tehsil (
    tehsil_id integer NOT NULL,
    tehsil_name character varying(500) NOT NULL,
    district_id integer NOT NULL,
    tehsil_name_ur character varying(500)
);


ALTER TABLE public.tehsil OWNER TO postgres;

--
-- Name: tehsil_tehsil_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tehsil_tehsil_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tehsil_tehsil_id_seq OWNER TO postgres;

--
-- Name: tehsil_tehsil_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tehsil_tehsil_id_seq OWNED BY public.tehsil.tehsil_id;


--
-- Name: terrain; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.terrain (
    terrain_id integer NOT NULL,
    uc_id integer NOT NULL,
    soil_type character varying(100) NOT NULL,
    land_type character varying(100) NOT NULL
);


ALTER TABLE public.terrain OWNER TO postgres;

--
-- Name: terrain_terrain_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.terrain_terrain_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.terrain_terrain_id_seq OWNER TO postgres;

--
-- Name: terrain_terrain_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.terrain_terrain_id_seq OWNED BY public.terrain.terrain_id;


--
-- Name: union_council; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.union_council (
    uc_id integer NOT NULL,
    uc_name character varying(500) NOT NULL,
    tehsil_id integer NOT NULL,
    us_name_ur character varying(500) NOT NULL,
    pp integer,
    na integer
);


ALTER TABLE public.union_council OWNER TO postgres;

--
-- Name: union_council_uc_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.union_council_uc_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.union_council_uc_id_seq OWNER TO postgres;

--
-- Name: union_council_uc_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.union_council_uc_id_seq OWNED BY public.union_council.uc_id;


--
-- Name: water_resource; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.water_resource (
    id integer NOT NULL,
    water_resource_name character varying(500) NOT NULL,
    water_resource_name_ur character varying(500) NOT NULL,
    water_resource_type_id integer NOT NULL,
    water_course character varying(500),
    total_length integer,
    coordinates public.geography,
    water_quality character varying(500),
    senction_discharge integer,
    design_discharge integer,
    gca integer,
    cca integer,
    meta_data json
);


ALTER TABLE public.water_resource OWNER TO postgres;

--
-- Name: water_resource_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.water_resource_type (
    id integer NOT NULL,
    water_resource_type_name character varying(500) NOT NULL,
    water_resource_type_name_ur character varying(500) NOT NULL
);


ALTER TABLE public.water_resource_type OWNER TO postgres;

--
-- Name: crop crop_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.crop ALTER COLUMN crop_id SET DEFAULT nextval('public.crop_crop_id_seq'::regclass);


--
-- Name: district district_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.district ALTER COLUMN district_id SET DEFAULT nextval('public.district_district_id_seq'::regclass);


--
-- Name: farmer farmer_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.farmer ALTER COLUMN farmer_id SET DEFAULT nextval('public.farmer_farmer_id_seq'::regclass);


--
-- Name: farmer_water_report report_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.farmer_water_report ALTER COLUMN report_id SET DEFAULT nextval('public.farmer_water_report_report_id_seq'::regclass);


--
-- Name: recommended_crops_report rec_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recommended_crops_report ALTER COLUMN rec_id SET DEFAULT nextval('public.recommended_crops_report_rec_id_seq'::regclass);


--
-- Name: season season_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.season ALTER COLUMN season_id SET DEFAULT nextval('public.season_season_id_seq'::regclass);


--
-- Name: tehsil tehsil_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tehsil ALTER COLUMN tehsil_id SET DEFAULT nextval('public.tehsil_tehsil_id_seq'::regclass);


--
-- Name: terrain terrain_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.terrain ALTER COLUMN terrain_id SET DEFAULT nextval('public.terrain_terrain_id_seq'::regclass);


--
-- Name: union_council uc_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.union_council ALTER COLUMN uc_id SET DEFAULT nextval('public.union_council_uc_id_seq'::regclass);


--
-- Data for Name: crop; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.crop (crop_id, crop_name, crop_type) FROM stdin;
\.


--
-- Data for Name: district; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.district (district_id, district_name, division_id, district_name_ur) FROM stdin;
\.


--
-- Data for Name: division; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.division (id, division_name, division_name_ur) FROM stdin;
\.


--
-- Data for Name: farmer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.farmer (farmer_id, name, cnic, phone, address, uc_id) FROM stdin;
\.


--
-- Data for Name: farmer_water_report; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.farmer_water_report (report_id, farmer_id, uc_id, terrain_id, season_id, wish_crop_id, generated_on, notes) FROM stdin;
\.


--
-- Data for Name: recommended_crops_report; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.recommended_crops_report (rec_id, report_id, crop_id, reason, notes) FROM stdin;
\.


--
-- Data for Name: season; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.season (season_id, season_name, start_month, end_month) FROM stdin;
\.


--
-- Data for Name: spatial_ref_sys; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.spatial_ref_sys (srid, auth_name, auth_srid, srtext, proj4text) FROM stdin;
\.


--
-- Data for Name: tehsil; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tehsil (tehsil_id, tehsil_name, district_id, tehsil_name_ur) FROM stdin;
\.


--
-- Data for Name: terrain; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.terrain (terrain_id, uc_id, soil_type, land_type) FROM stdin;
\.


--
-- Data for Name: union_council; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.union_council (uc_id, uc_name, tehsil_id, us_name_ur, pp, na) FROM stdin;
\.


--
-- Data for Name: water_resource; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.water_resource (id, water_resource_name, water_resource_name_ur, water_resource_type_id, water_course, total_length, coordinates, water_quality, senction_discharge, design_discharge, gca, cca, meta_data) FROM stdin;
\.


--
-- Data for Name: water_resource_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.water_resource_type (id, water_resource_type_name, water_resource_type_name_ur) FROM stdin;
\.


--
-- Name: crop_crop_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.crop_crop_id_seq', 1, false);


--
-- Name: district_district_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.district_district_id_seq', 1, false);


--
-- Name: farmer_farmer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.farmer_farmer_id_seq', 1, false);


--
-- Name: farmer_water_report_report_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.farmer_water_report_report_id_seq', 1, false);


--
-- Name: recommended_crops_report_rec_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.recommended_crops_report_rec_id_seq', 1, false);


--
-- Name: season_season_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.season_season_id_seq', 1, false);


--
-- Name: tehsil_tehsil_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tehsil_tehsil_id_seq', 1, false);


--
-- Name: terrain_terrain_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.terrain_terrain_id_seq', 1, false);


--
-- Name: union_council_uc_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.union_council_uc_id_seq', 1, false);


--
-- Name: division Division_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.division
    ADD CONSTRAINT "Division_pkey" PRIMARY KEY (id);


--
-- Name: crop crop_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.crop
    ADD CONSTRAINT crop_pkey PRIMARY KEY (crop_id);


--
-- Name: district district_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.district
    ADD CONSTRAINT district_pkey PRIMARY KEY (district_id);


--
-- Name: farmer farmer_cnic_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.farmer
    ADD CONSTRAINT farmer_cnic_key UNIQUE (cnic);


--
-- Name: farmer farmer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.farmer
    ADD CONSTRAINT farmer_pkey PRIMARY KEY (farmer_id);


--
-- Name: farmer_water_report farmer_water_report_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.farmer_water_report
    ADD CONSTRAINT farmer_water_report_pkey PRIMARY KEY (report_id);


--
-- Name: recommended_crops_report recommended_crops_report_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recommended_crops_report
    ADD CONSTRAINT recommended_crops_report_pkey PRIMARY KEY (rec_id);


--
-- Name: season season_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.season
    ADD CONSTRAINT season_pkey PRIMARY KEY (season_id);


--
-- Name: tehsil tehsil_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tehsil
    ADD CONSTRAINT tehsil_pkey PRIMARY KEY (tehsil_id);


--
-- Name: terrain terrain_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.terrain
    ADD CONSTRAINT terrain_pkey PRIMARY KEY (terrain_id);


--
-- Name: union_council union_council_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.union_council
    ADD CONSTRAINT union_council_pkey PRIMARY KEY (uc_id);


--
-- Name: water_resource water_resource_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.water_resource
    ADD CONSTRAINT water_resource_pkey PRIMARY KEY (id);


--
-- Name: water_resource_type water_resource_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.water_resource_type
    ADD CONSTRAINT water_resource_type_pkey PRIMARY KEY (id);


--
-- Name: farmer farmer_uc_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.farmer
    ADD CONSTRAINT farmer_uc_id_fkey FOREIGN KEY (uc_id) REFERENCES public.union_council(uc_id) ON DELETE CASCADE;


--
-- Name: farmer_water_report farmer_water_report_farmer_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.farmer_water_report
    ADD CONSTRAINT farmer_water_report_farmer_id_fkey FOREIGN KEY (farmer_id) REFERENCES public.farmer(farmer_id) ON DELETE CASCADE;


--
-- Name: farmer_water_report farmer_water_report_season_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.farmer_water_report
    ADD CONSTRAINT farmer_water_report_season_id_fkey FOREIGN KEY (season_id) REFERENCES public.season(season_id) ON DELETE CASCADE;


--
-- Name: farmer_water_report farmer_water_report_terrain_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.farmer_water_report
    ADD CONSTRAINT farmer_water_report_terrain_id_fkey FOREIGN KEY (terrain_id) REFERENCES public.terrain(terrain_id) ON DELETE CASCADE;


--
-- Name: farmer_water_report farmer_water_report_uc_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.farmer_water_report
    ADD CONSTRAINT farmer_water_report_uc_id_fkey FOREIGN KEY (uc_id) REFERENCES public.union_council(uc_id) ON DELETE CASCADE;


--
-- Name: farmer_water_report farmer_water_report_wish_crop_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.farmer_water_report
    ADD CONSTRAINT farmer_water_report_wish_crop_id_fkey FOREIGN KEY (wish_crop_id) REFERENCES public.crop(crop_id);


--
-- Name: district fk_division; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.district
    ADD CONSTRAINT fk_division FOREIGN KEY (division_id) REFERENCES public.division(id) NOT VALID;


--
-- Name: water_resource fk_water_resource_type_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.water_resource
    ADD CONSTRAINT fk_water_resource_type_id FOREIGN KEY (water_resource_type_id) REFERENCES public.water_resource_type(id) NOT VALID;


--
-- Name: recommended_crops_report recommended_crops_report_crop_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recommended_crops_report
    ADD CONSTRAINT recommended_crops_report_crop_id_fkey FOREIGN KEY (crop_id) REFERENCES public.crop(crop_id) ON DELETE CASCADE;


--
-- Name: recommended_crops_report recommended_crops_report_report_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recommended_crops_report
    ADD CONSTRAINT recommended_crops_report_report_id_fkey FOREIGN KEY (report_id) REFERENCES public.farmer_water_report(report_id) ON DELETE CASCADE;


--
-- Name: tehsil tehsil_district_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tehsil
    ADD CONSTRAINT tehsil_district_id_fkey FOREIGN KEY (district_id) REFERENCES public.district(district_id) ON DELETE CASCADE;


--
-- Name: terrain terrain_uc_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.terrain
    ADD CONSTRAINT terrain_uc_id_fkey FOREIGN KEY (uc_id) REFERENCES public.union_council(uc_id) ON DELETE CASCADE;


--
-- Name: union_council union_council_tehsil_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.union_council
    ADD CONSTRAINT union_council_tehsil_id_fkey FOREIGN KEY (tehsil_id) REFERENCES public.tehsil(tehsil_id) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

\unrestrict ld9Duh8awo9mIWU9TnGRTcfhlDUc2pKyW7fsqf8ViGsjgYgwRfahXKcKv9LZcha

