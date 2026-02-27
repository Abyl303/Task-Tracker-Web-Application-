# Task Tracker (Spring Boot + PostgreSQL + Thymeleaf)

Task Tracker — CRUD веб-приложение для управления задачами.  
Поддерживает создание/редактирование/удаление задач и фильтрацию по приоритету.

## Features
- CRUD для задач (Create / Read / Update / Delete)
- Страница со списком задач + форма создания/редактирования (Thymeleaf)
- Фильтрация задач по `priority`
- PostgreSQL + Spring Data JPA (Hibernate)
- Docker / Docker Compose для быстрого запуска

## Tech Stack
- Java 17
- Spring Boot (Web, Thymeleaf, Data JPA)
- PostgreSQL
- Hibernate
- Maven
- Docker, Docker Compose

---

# 1) Запуск локально (без Docker)

## Требования
- Java 17
- PostgreSQL
- Maven (или запуск из IntelliJ)

## Настройка базы
Создай базу (пример):

CREATE DATABASE tasks;

---

# 2) Запуск через Docker Compose (рекомендуется)

## Требования
- Docker 
- Docker Compose

## Файлы
В проекте есть:
-Dockerfile
-docker-compose.yml

## Запуск
Из корня проекта:

docker compose up --build

Открыть в браузере:

http://localhost:8080/tasks

## Остановка

docker compose down

# 3) Ngrok (показать проект людям)
Установка и логин:
- Установи ngrok
- Авторизуйся:

ngrok config add-authtoken YOUR_TOKEN
Запуск туннеля:

ngrok http 8080

Ngrok покажет публичную ссылку вида:

https://xxxx-xx-xx-xx.ngrok-free.app

Эту ссылку можно отправить, чтобы люди открыли твоё приложение.

Author

Abylaikhan Izmakhanov
GitHub: https://github.com/Abyl303
