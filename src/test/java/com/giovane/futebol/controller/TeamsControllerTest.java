package com.giovane.futebol.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.giovane.futebol.dto.TeamRequestDto;
import com.giovane.futebol.dto.TeamResponseDto;
import com.giovane.futebol.service.TeamService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@EnableWebMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
class TeamsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    TeamService teamService;



    // CHECK
    @Test
    void save_team_201() throws Exception {
        TeamRequestDto teamRequestDto = TeamRequestDto.builder()
                .id(1)
                .name("Internacional")
                .stadium("Beira-rio")
                .country("Brazil")
                .build();
        mockMvc.perform(post("/api/v1/soccer/team")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(teamRequestDto)))
                .andExpect(status().isCreated());
    }

    // CHECK
    @Test
    void save_team_400() throws Exception {
        TeamRequestDto teamRequestDto = TeamRequestDto.builder()
                .id(1)
                .name("Internacional")
                .stadium("Beira-rio")
                .country("Brazil")
                .build();
        mockMvc.perform(post("/api/v1/soccer/team/g")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(teamRequestDto)))
                .andExpect(status().isBadRequest());
    }



    // CHECK
    @Test
    public void update_team_204() throws Exception {
        TeamRequestDto teamRequestDto = TeamRequestDto.builder()
                .name("Barcelona")
                .stadium("Camp Nou")
                .country("Spain")
                .build();

        Mockito.when(teamService.save(teamRequestDto)).thenReturn(teamRequestDto);
        mockMvc.perform(put("/api/v1/soccer/team/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(teamRequestDto)))
                .andExpect(status().isNoContent());
    }

    // CHECK
    @Test
    public void update_team_400() throws Exception {
        TeamRequestDto teamRequestDto = TeamRequestDto.builder()
                .name("Barcelona")
                .stadium("Camp Nou")
                .country("Spain")
                .build();

        Mockito.when(teamService.save(teamRequestDto)).thenReturn(teamRequestDto);
        mockMvc.perform(put("/api/v1/soccer/team/g")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(teamRequestDto)))
                .andExpect(status().isBadRequest());
    }

    // IT'S NOT YET FINISH
    @Test
    public void update_team_404() throws Exception {
        TeamRequestDto teamRequestDto = TeamRequestDto.builder()
                .name("Barcelona")
                .stadium("Camp Nou")
                .country("Spain")
                .build();
        Mockito.when(teamService.save(teamRequestDto)).thenReturn(teamRequestDto);
        mockMvc.perform(put("/api/v1/soccer/team/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(teamRequestDto)))
                .andExpect(status().isNotFound());
    }



    // CHECK
    @Test
    void delete_byId_204() throws Exception {
        mockMvc.perform(delete("/api/v1/soccer/team/1"))
                .andExpect(status().isNoContent());

    }

    // CHECK
    @Test
    void delete_byId_400() throws Exception {
        mockMvc.perform(delete("/api/v1/soccer/team/g"))
                .andExpect(status().isBadRequest());
    }

    // IT'S NOT YET FINISH
    @Test
    void delete_byId_404() throws Exception {
        Mockito.when(teamService.findById(1)).thenReturn(Optional.empty());
        mockMvc.perform(delete("/api/v1/soccer/team/3"))
                .andExpect(status().isNotFound());
    }



    // CHECK
    @Test
    void find_all_200() throws Exception {
        mockMvc.perform(get("/api/v1/soccer/teams"))
                .andExpect(status().isOk());
    }



    // CHECK
    @Test
    void find_ById_200() throws Exception {
        Mockito.when(teamService.findById(1)).thenReturn(Optional
                .of(new TeamResponseDto(1, "Internacional", "Beira-rio", "Brazil")));
        mockMvc.perform(get("/api/v1/soccer/team/1"))
                .andExpect(status().isOk());
    }

    // CHECK
    @Test
    void find_ById_400() throws Exception {
        mockMvc.perform(get("/api/v1/soccer/team/g"))
                .andExpect(status().isBadRequest());
    }

    // IT'S NOT YET FINISH
    @Test
    void find_ById_404() throws Exception {
       Mockito.when(teamService.findById(1)).thenReturn(Optional.empty());
        mockMvc.perform(get("/api/v1/soccer/team/6"))
                .andExpect(status().isNotFound());
    }



}