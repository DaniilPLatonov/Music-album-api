# Music Album API

RESTful API для управления музыкальными альбомами и песнями.

## Зависимости

Для сборки и запуска приложения необходимо иметь следующие зависимости:
- Java 17
- Spring Boot 3.1.0
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- Spring Boot DevTools (runtime, optional)
- PostgreSQL (runtime)
- Spring Boot Starter Test (scope: test)


## Сборка и запуск

1. Установите Java 17, если у вас еще его нет.
2. Склонируйте репозиторий с проектом:

   ```shell
   git clone https://github.com/yourcompany/music-album-api.git

3. Перейдите в каталог проекта:
    ```shell
     cd music-album-api
    ```
4. Соберите проект с использованием Maven:
   ```shell
    mvn clean install
   ```
5. Запустите приложение:
    ```shell
   mvn spring-boot:run
    ```

## Дополнительная конфигурация
## Настройка базы данных

По умолчанию, приложение использует PostgreSQL в качестве базы данных. Если у вас еще нет PostgreSQL, установите его и настройте подключение в файле application.properties.
```
spring.datasource.url=jdbc:postgresql://localhost:5432/db_name
spring.datasource.username=db_username
spring.datasource.password=db_password
```

Замените db_name, db_username и db_password соответствующими значениями вашей базы данных.

Порт приложения
Если вы хотите изменить порт, на котором запускается приложение, отредактируйте значение в файле application.properties.
```
server.port=8080
```
Замените 8080 на желаемый порт.

## Использование API

Проект предоставляет следующие API для работы с альбомами и песнями:
```
- GET /albums - Получить список всех альбомов
- GET /albums/{id} - Получить альбом по его ID
- POST /albums - Создать новый альбом
- PUT /albums/{id} - Обновить информацию об альбоме
- DELETE /albums/{id} - Удалить альбом по его ID

- GET /songs - Получить список всех песен
- GET /songs/{id} - Получить песню по ее ID
- POST /songs - Создать новую песню
- PUT /songs/{id} - Обновить информацию о песне
- DELETE /songs/{id} - Удалить песню по ее ID
```

При использовании POST и PUT запросов, данные должны быть отправлены в формате JSON.