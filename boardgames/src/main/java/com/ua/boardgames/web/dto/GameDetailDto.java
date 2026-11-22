package com.ua.boardgames.web.dto;

import java.math.BigDecimal;

public record GameDetailDto(Long id, String title, String publisher, BigDecimal price,
                            Integer year, String imageUrl, String description, String genre,
                            Integer minPlayers, Integer maxPlayers) {
}
