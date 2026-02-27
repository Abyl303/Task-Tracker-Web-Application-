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
```sql
CREATE DATABASE tasks;
