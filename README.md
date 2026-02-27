Task Tracker — это CRUD веб-приложение для управления задачами, разработанное с использованием Java 17, Spring Boot, PostgreSQL и Thymeleaf.
Приложение позволяет создавать, редактировать, удалять задачи и фильтровать их по приоритету.

Проект демонстрирует базовую backend архитектуру Spring-приложения и может использоваться как учебный проект для Junior Java Backend Developer.

Features

Создание задач

Редактирование задач

Удаление задач

Просмотр списка задач

Фильтрация задач по приоритету

Автоматическое создание timestamps (createdAt / updatedAt)

Web UI на Thymeleaf

Работа с БД через Spring Data JPA + Hibernate

Контейнеризация через Docker и Docker Compose

Tech Stack

Backend:

Java 17

Spring Boot

Spring Web MVC

Spring Data JPA

Hibernate

Database:

PostgreSQL

Frontend:

Thymeleaf

HTML / CSS

Tools:

Maven

Docker

Docker Compose

IntelliJ IDEA

Git

Architecture:

Layered Architecture

MVC pattern

Repository pattern

Entity-based persistence (JPA)

Architecture

Приложение построено по стандартной архитектуре Spring Boot:

Controller Layer
Обрабатывает HTTP-запросы и возвращает HTML страницы.

Service Layer
Содержит бизнес-логику приложения.

Repository Layer
Работает с базой данных через Spring Data JPA.

Entity Layer
JPA-модели, отображаемые в таблицы базы данных.

Database Model

Task содержит следующие поля:

id — уникальный идентификатор
title — название задачи
description — описание
status — статус задачи (enum)
priority — приоритет (enum)
dueDate — срок выполнения
createdAt — дата создания
updatedAt — дата последнего изменения

Running the Project
1. Run locally (without Docker)

Requirements:

Java 17

PostgreSQL

Maven

Create database:

CREATE DATABASE tasks;

application.properties example:

spring.datasource.url=jdbc:postgresql://localhost:5432/tasks
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Build project:

mvn clean package

Run application:

mvn spring-boot:run

Open in browser:

http://localhost:8080/tasks
Run with Docker (recommended)

Requirements:

Docker

Docker Compose

Run application:

docker compose up --build

Application will be available at:

http://localhost:8080/tasks

Stop containers:

docker compose down

Stop and delete database volume:

docker compose down -v
Docker Configuration

Docker Compose запускает два контейнера:

PostgreSQL database
Spring Boot application

Database container:

postgres:16

Environment variables used by application:

SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD

Example:

SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/tasks
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=postgres
Ngrok (Public Access)

Чтобы показать приложение другим людям, можно использовать ngrok.

Install ngrok and authenticate:

ngrok config add-authtoken YOUR_TOKEN

Start tunnel:

ngrok http 8080

Ngrok выдаст публичную ссылку, например:

https://xxxx-xxxx.ngrok-free.app

Эту ссылку можно отправить другим людям для просмотра приложения.

Project Structure
src/main/java/com/example/tasktracker

controller
    TaskController

service
    TaskService

repository
    TaskRepository

model
    Task
    TaskStatus
    TaskPriority

templates

templates/tasks.html
Future Improvements

Possible improvements for the project:

Swagger / OpenAPI documentation

REST API version of the application

Pagination and sorting

Search by title

DTO layer

Validation annotations

Unit and integration tests

Authentication (Spring Security)

Task ownership (User entity)

Author

Abylaikhan Izmakhanov

GitHub
https://github.com/Abyl303
