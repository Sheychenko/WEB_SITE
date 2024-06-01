# Используем образ с Maven для сборки и запуска проекта
FROM maven:latest

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файлы с исходным кодом в контейнер
COPY . /app

# Запускаем приложение Spring Boot с помощью Maven
CMD ["./mvnw", "spring-boot:run"]
