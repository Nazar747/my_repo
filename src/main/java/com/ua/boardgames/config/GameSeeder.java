package com.ua.boardgames.config;

import com.ua.boardgames.domain.Game;
import com.ua.boardgames.repository.GameRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class GameSeeder implements ApplicationRunner {

    private final GameRepository repository;

    public GameSeeder(GameRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(ApplicationArguments args) {
        repository.save(new Game(null, "Катан", "Kosmos", new BigDecimal("1450.00"), 1995,
                "/images/catan.jpg",
                "Класична гра про розвиток островів: збирайте ресурси, торгуйте та будуйте поселення.",
                "Стратегія", 3, 4));
        repository.save(new Game(null, "Диксит", "Libellud", new BigDecimal("1300.00"), 2008,
                "/images/dixit.jpg",
                "Асоціативна гра з ілюстраціями: розповідайте історії за картками й вгадуйте задум.",
                "Сімейна", 3, 6));
        repository.save(new Game(null, "Каркассон", "Hans im Glück", new BigDecimal("990.00"), 2000,
                "/images/carcassonne.jpg",
                "Викладайте тайли, створюючи середньовічний ландшафт із містами, дорогами та полями.",
                "Стратегія", 2, 5));
        repository.save(new Game(null, "Мафія", "Різні видавці", new BigDecimal("450.00"), 1986,
                "/images/mafia.jpg",
                "Соціальна гра для великої компанії: мирні жителі шукають мафію серед себе.",
                "Вечіркова", 6, 15));
        repository.save(new Game(null, "Ticket to Ride", "Days of Wonder", new BigDecimal("1850.00"), 2004,
                "/images/ticket-to-ride.jpg",
                "Збирайте вагони й прокладайте залізничні маршрути між містами.",
                "Сімейна", 2, 5));
    }
}
