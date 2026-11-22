package com.ua.boardgames.domain;

import java.math.BigDecimal;

public class Game {
    private Long id;
    private String title;
    private String publisher;
    private BigDecimal price;
    private Integer year;
    private String imageUrl;      // зображення (для картки)
    private String description;   // опис (для сторінки гри)
    private String genre;
    private Integer minPlayers;
    private Integer maxPlayers;

    public Game() {
    }

    public Game(Long id, String title, String publisher, BigDecimal price, Integer year,
                String imageUrl, String description, String genre,
                Integer minPlayers, Integer maxPlayers) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.price = price;
        this.year = year;
        this.imageUrl = imageUrl;
        this.description = description;
        this.genre = genre;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public Integer getMinPlayers() { return minPlayers; }
    public void setMinPlayers(Integer minPlayers) { this.minPlayers = minPlayers; }
    public Integer getMaxPlayers() { return maxPlayers; }
    public void setMaxPlayers(Integer maxPlayers) { this.maxPlayers = maxPlayers; }
}
