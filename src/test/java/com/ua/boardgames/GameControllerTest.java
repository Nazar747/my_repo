package com.ua.boardgames;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GameControllerTest {

    private static final String BODY = """
            {"title":"Нова гра","publisher":"Тест","price":199.00,"year":2024,
             "imageUrl":"/images/x.jpg","description":"Опис","genre":"Карткова",
             "minPlayers":2,"maxPlayers":4}""";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void listReturnsCardsWithoutDescription() throws Exception {
        mockMvc.perform(get("/api/games"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").exists())
                .andExpect(jsonPath("$[0].description").doesNotExist());
    }

    @Test
    void listFiltersByGenre() throws Exception {
        mockMvc.perform(get("/api/games").param("genre", "Вечіркова"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].title").value("Мафія"));
    }

    @Test
    void getOneReturnsDetails() throws Exception {
        mockMvc.perform(get("/api/games/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.description").exists());
    }

    @Test
    void getOneUnknownIdReturns404() throws Exception {
        mockMvc.perform(get("/api/games/999")).andExpect(status().isNotFound());
    }

    @Test
    void createReturns201AndGeneratedId() throws Exception {
        mockMvc.perform(post("/api/games").contentType(MediaType.APPLICATION_JSON).content(BODY))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.title").value("Нова гра"));
    }

    @Test
    void updateReturns200() throws Exception {
        mockMvc.perform(put("/api/games/2").contentType(MediaType.APPLICATION_JSON).content(BODY))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.title").value("Нова гра"));
    }

    @Test
    void updateUnknownIdReturns404() throws Exception {
        mockMvc.perform(put("/api/games/999").contentType(MediaType.APPLICATION_JSON).content(BODY))
                .andExpect(status().isNotFound());
    }

    @Test
    void deleteReturns204ThenSecondDeleteReturns404() throws Exception {
        mockMvc.perform(delete("/api/games/3")).andExpect(status().isNoContent());
        mockMvc.perform(delete("/api/games/3")).andExpect(status().isNotFound());
    }
}
