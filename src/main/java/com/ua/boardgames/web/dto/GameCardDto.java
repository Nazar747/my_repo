package com.ua.boardgames.web.dto;

import java.math.BigDecimal;

public record GameCardDto(Long id, String title, String publisher,
                          BigDecimal price, String imageUrl) {
}
