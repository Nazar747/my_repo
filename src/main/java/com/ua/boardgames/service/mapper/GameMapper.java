package com.ua.boardgames.service.mapper;

import com.ua.boardgames.domain.Game;
import com.ua.boardgames.web.dto.GameCardDto;
import com.ua.boardgames.web.dto.GameDetailDto;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {

    public GameCardDto toCard(Game g) {
        return new GameCardDto(g.getId(), g.getTitle(), g.getPublisher(),
                g.getPrice(), g.getImageUrl());
    }

    public GameDetailDto toDetail(Game g) {
        return new GameDetailDto(g.getId(), g.getTitle(), g.getPublisher(), g.getPrice(),
                g.getYear(), g.getImageUrl(), g.getDescription(), g.getGenre(),
                g.getMinPlayers(), g.getMaxPlayers());
    }
}
