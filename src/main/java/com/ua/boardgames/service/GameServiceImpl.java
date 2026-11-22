package com.ua.boardgames.service;

import com.ua.boardgames.domain.Game;
import com.ua.boardgames.exception.GameNotFoundException;
import com.ua.boardgames.repository.GameRepository;
import com.ua.boardgames.service.mapper.GameMapper;
import com.ua.boardgames.web.dto.GameCardDto;
import com.ua.boardgames.web.dto.GameDetailDto;
import com.ua.boardgames.web.dto.GameRequest;
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
    public List<GameCardDto> findAll(String genre) {
        List<Game> games = (genre == null || genre.isBlank())
                ? repository.findAll()
                : repository.findByGenre(genre);
        return games.stream().map(mapper::toCard).toList();
    }

    @Override
    public GameDetailDto findById(Long id) {
        Game game = repository.findById(id)
                .orElseThrow(() -> new GameNotFoundException(id));
        return mapper.toDetail(game);
    }

    @Override
    public GameDetailDto create(GameRequest request) {
        Game game = mapper.toDomain(request);
        game.setId(null);
        return mapper.toDetail(repository.save(game));
    }

    @Override
    public GameDetailDto update(Long id, GameRequest request) {
        repository.findById(id).orElseThrow(() -> new GameNotFoundException(id));
        Game game = mapper.toDomain(request);
        game.setId(id);
        return mapper.toDetail(repository.save(game));
    }

    @Override
    public void delete(Long id) {
        if (!repository.deleteById(id)) {
            throw new GameNotFoundException(id);
        }
    }
}
