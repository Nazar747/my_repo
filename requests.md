# Приклади запитів (curl)

Запуск: `./mvnw spring-boot:run` (сервер на http://localhost:8080)

## 1. Перелік ігор (картки) — 200
```bash
curl http://localhost:8080/api/games
```

## 2. Фільтр за жанром (@RequestParam) — 200
```bash
curl "http://localhost:8080/api/games?genre=Стратегія"
```

## 3. Одна гра з деталями — 200 / 404
```bash
curl http://localhost:8080/api/games/1
curl -i http://localhost:8080/api/games/999
```

## 4. Створити гру — 201
```bash
curl -i -X POST http://localhost:8080/api/games \
  -H "Content-Type: application/json" \
  -d '{"title":"Нова гра","publisher":"Видавець","price":199.00,"year":2024,"imageUrl":"/images/x.jpg","description":"Опис","genre":"Карткова","minPlayers":2,"maxPlayers":4}'
```

## 5. Оновити гру — 200 / 404
```bash
curl -i -X PUT http://localhost:8080/api/games/1 \
  -H "Content-Type: application/json" \
  -d '{"title":"Оновлена гра","publisher":"Видавець","price":250.00,"year":2024,"imageUrl":"/images/x.jpg","description":"Новий опис","genre":"Стратегія","minPlayers":2,"maxPlayers":4}'

curl -i -X PUT http://localhost:8080/api/games/999 \
  -H "Content-Type: application/json" \
  -d '{"title":"X","publisher":"Y","price":1,"year":2024,"imageUrl":"","description":"","genre":"Z","minPlayers":1,"maxPlayers":2}'
```

## 6. Видалити гру — 204 / 404
```bash
curl -i -X DELETE http://localhost:8080/api/games/2
curl -i -X DELETE http://localhost:8080/api/games/999
```
