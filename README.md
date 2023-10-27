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
## 1. Заполнить файл [*properties*](https://github.com/FattAkvarium/Weather-Measurement-Sensor/blob/master/src/main/resources/application.properties.orig), удалить окончание .orig


## 2. Запустить скрипт [*database Postgres*](https://github.com/FattAkvarium/Weather-Measurement-Sensor/blob/master/src/main/resources/database.properties.orig) для создания таблиц Sensor и Measurement

