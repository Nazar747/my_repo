# Приклади запитів (curl)

Запуск: `./mvnw spring-boot:run` (сервер на http://localhost:8080)

## Перелік ігор (картки)
```bash
curl http://localhost:8080/api/games
```

## Одна гра з деталями
```bash
curl http://localhost:8080/api/games/1
```

## Неіснуюча гра → 404
```bash
curl -i http://localhost:8080/api/games/999
```
