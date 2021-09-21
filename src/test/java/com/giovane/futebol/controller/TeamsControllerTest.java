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
@SpringBootTest()
class TeamsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    TeamService teamService;

    @Test
    void post_201() throws Exception {
        TeamRequestDto teamRequestDto = TeamRequestDto.builder()
                .id(1)
                .name("Giovane")
                .stadium("Beira-rio")
                .country("Brazil")
                .build();
        mockMvc.perform(post("/api/v1/soccer/team")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(teamRequestDto)))
                .andExpect(status().isCreated());
    }






    @Test
    void findById_200() throws Exception {
        Mockito.when(teamService.findById(1)).thenReturn(Optional
                .of(new TeamResponseDto(1, "fwd", "rrr", "gre")));
        mockMvc.perform(get("/api/v1/soccer/team/1")).andExpect(status().isOk());
    }

    @Test
    public void findById_404() throws Exception {
        Mockito.when(teamService.findById(1)).thenReturn(Optional.empty());
        mockMvc.perform(get("/api/v1/soccer/team/3")).andExpect(status().isNotFound());
    }




    @Test
    void delete_byId_200() throws Exception {
        mockMvc.perform(delete("/api/v1/soccer/team/1"))
                .andExpect(status().isOk());

    }





}