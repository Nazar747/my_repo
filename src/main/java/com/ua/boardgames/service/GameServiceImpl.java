package com.ua.boardgames.service;

import com.ua.boardgames.domain.Game;
import com.ua.boardgames.exception.GameNotFoundException;
import com.ua.boardgames.repository.GameRepository;
import com.ua.boardgames.service.mapper.GameMapper;
import com.ua.boardgames.web.dto.GameCardDto;
import com.ua.boardgames.web.dto.GameDetailDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository repository;
    private final GameMapper mapper;

    public GameServiceImpl(GameRepository repository, GameMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<GameCardDto> findAll() {
        return repository.findAll().stream().map(mapper::toCard).toList();
    }

    @Override
    public GameDetailDto findById(Long id) {
        Game game = repository.findById(id)
                .orElseThrow(() -> new GameNotFoundException(id));
        return mapper.toDetail(game);
    }
}
