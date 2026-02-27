Task Tracker (Spring Boot + PostgreSQL + Thymeleaf)

Task Tracker — CRUD веб-приложение для управления задачами.
Поддерживает создание, редактирование, удаление задач и фильтрацию по приоритету.

Features

CRUD для задач (Create / Read / Update / Delete)

Страница со списком задач и форма создания/редактирования (Thymeleaf)

Фильтрация задач по priority

PostgreSQL + Spring Data JPA (Hibernate)

Docker / Docker Compose для быстрого запуска

Tech Stack

Java 17

Spring Boot (Web, Thymeleaf, Data JPA)

PostgreSQL

Hibernate

Maven

Docker, Docker Compose

1) Запуск локально (без Docker)
Требования

Java 17

PostgreSQL

Maven (или запуск из IntelliJ)

Настройка базы

Создай базу данных:

CREATE DATABASE tasks;
application.properties

Файл:

src/main/resources/application.properties

Пример конфигурации:

spring.datasource.url=jdbc:postgresql://localhost:5432/tasks
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Сборка проекта
mvn clean package
Запуск приложения
mvn spring-boot:run
Открыть приложение
http://localhost:8080/tasks
2) Запуск через Docker Compose (рекомендуется)
Требования

Docker

Docker Compose

Файлы

В проекте уже есть:

Dockerfile
docker-compose.yml
Запуск

Из корня проекта:

docker compose up --build

После запуска приложение будет доступно по адресу:

http://localhost:8080/tasks
Остановка
docker compose down
3) Ngrok (показать проект другим людям)

Ngrok позволяет открыть локальное приложение для доступа через интернет.

Установка и авторизация

Установи ngrok и авторизуйся:

ngrok config add-authtoken YOUR_TOKEN
Запуск туннеля
ngrok http 8080

Ngrok выдаст публичную ссылку, например:

https://xxxx-xx-xx-xx.ngrok-free.app

Эту ссылку можно отправить другим людям, чтобы они могли открыть твое приложение.

Author

Abylaikhan Izmakhanov

GitHub
https://github.com/Abyl303
