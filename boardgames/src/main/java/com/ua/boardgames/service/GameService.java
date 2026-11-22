package com.ua.boardgames.service;

import com.ua.boardgames.web.dto.GameCardDto;
import com.ua.boardgames.web.dto.GameDetailDto;

import java.util.List;

public interface GameService {
    List<GameCardDto> findAll();

    GameDetailDto findById(Long id);
}
