package com.ua.boardgames.web;

import com.ua.boardgames.service.GameService;
import com.ua.boardgames.web.dto.GameCardDto;
import com.ua.boardgames.web.dto.GameDetailDto;
import com.ua.boardgames.web.dto.GameRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameCardDto> list(@RequestParam(required = false) String genre) {
        return gameService.findAll(genre);
    }

    @GetMapping("/{id}")
    public GameDetailDto getOne(@PathVariable Long id) {
        return gameService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    public GameDetailDto create(@RequestBody GameRequest request) {
        return gameService.create(request);
    }

    @PutMapping("/{id}")
    public GameDetailDto update(@PathVariable Long id, @RequestBody GameRequest request) {
        return gameService.update(id, request); // 200, або 404 якщо немає
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        gameService.delete(id);
        return ResponseEntity.noContent().build(); // 204
    }
}
