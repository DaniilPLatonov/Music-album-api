# Music Album API

RESTful API для управления музыкальными альбомами и песнями.

## Предметная область

Предметная область проекта связана с управлением музыкальными альбомами и песнями.
Объекты, которые мы используем в этой предметной области, включают:

- Альбом (Album):
  -  Название (Title)
  -  Исполнитель (Artist)
  -  Год выпуска (Release Year)
  -  Жанр (Genre)
  

- Песня (Song):
  - Название (Title)
  - студия звукозаписи (recordLabel)
  - Продолжительность (Duration): длительность песни в  секундах
  - Текст песни (Lyrics)
  - Язык (Language)
  - Идентификатор альбома (Album ID)

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
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.connection-timeout=30000
spring.datasource.hikari.idle-timeout=600000
spring.datasource.hikari.close-spring-annotation=true
```

Замените db_name, db_username и db_password соответствующими значениями вашей базы данных.

 - spring.datasource.hikari.maximum-pool-size: Устанавливает максимальное количество соединений в пуле базы данных.

 - spring.datasource.hikari.minimum-idle: Устанавливает минимальное количество неиспользуемых соединений в пуле базы данных. 
 - spring.datasource.hikari.connection-timeout: Устанавливает максимальное время ожидания для получения соединения с базой данных. 
 - spring.datasource.hikari.idle-timeout: Устанавливает максимальное время, в течение которого соединение может оставаться неиспользуемым в пуле базы данных, прежде чем будет закрыто.
 - spring.datasource.hikari.close-spring-annotation: Указывает, должен ли пул соединений закрывать соединения автоматически при закрытии контекста Spring. Значение true означает, что соединения будут закрыты автоматически при завершении работы приложения.

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