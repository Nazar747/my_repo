package com.ua.boardgames.service;

import com.ua.boardgames.web.dto.GameCardDto;
import com.ua.boardgames.web.dto.GameDetailDto;
import com.ua.boardgames.web.dto.GameRequest;

import java.util.List;

public interface GameService {
    List<GameCardDto> findAll(String genre); // фільтр за жанром (null = усі)

    GameDetailDto findById(Long id);

    GameDetailDto create(GameRequest request);

    GameDetailDto update(Long id, GameRequest request);

    void delete(Long id);
}
