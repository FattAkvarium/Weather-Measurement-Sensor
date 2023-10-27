# Проект Weather Measurement Sensor 
***
## Основная идея ##


*Это ***REST API*** сервис для метеорологического датчика (так как это учебный проект, сенсором выступает наш ПК), который измеряет температуру окружающего воздуха и может определить идет дождь или нет.
Получаем данный с сенсора и сохраняем их в БД, для дальнейшего анализа.*
***
## Базовая реализация
1. Регистрация нового сенсора с системе.
2. Добавление измерений для конкретного сенсора.
3. Возвращение всех измерений из БД.
4. Возвращение количества дождливых дней из БД
5. Используя RestTemplate отправляем 1000 запросов со случайными температурами и дождями.
6. Получаем с помощью RestTemplate 1000 измерений с серера по GET запросу.
***
## Стек технологий
***
1. Spring Boot
2. Maven
3. Postgre SQL
4. RestTemplate
5. Postman
***
## Запуск
### [*properties*](https://github.com/FattAkvarium/Weather-Measurement-Sensor/blob/master/src/main/resources/application.properties.orig)
```sh
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.show_sql=true
```

## [*database Postgres*](https://github.com/FattAkvarium/Weather-Measurement-Sensor/blob/master/src/main/resources/database.properties.orig)

**Таблица Sensor** 
```sh
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
```

**Таблица Measurement**
```sh
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
```
