
CREATE TABLE IF NOT EXISTS public.sensor
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT sensor_pkey PRIMARY KEY (id),
    CONSTRAINT sensor_name_key UNIQUE (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.sensor
    OWNER to postgres;



CREATE TABLE IF NOT EXISTS public.measurement
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    value double precision NOT NULL,
    raining boolean NOT NULL,
    measurement_date_time timestamp without time zone NOT NULL,
    sensor character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT measurement_pkey PRIMARY KEY (id),
    CONSTRAINT measurement_sensor_fkey FOREIGN KEY (sensor)
        REFERENCES public.sensor (name) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.measurement
    OWNER to postgres;