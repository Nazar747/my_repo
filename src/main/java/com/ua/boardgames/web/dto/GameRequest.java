package com.ua.boardgames.web.dto;

import java.math.BigDecimal;

/** Вхідний DTO для POST/PUT: без id — його задає сервер. */
public record GameRequest(String title, String publisher, BigDecimal price, Integer year,
                          String imageUrl, String description, String genre,
                          Integer minPlayers, Integer maxPlayers) {
}
