package com.giovane.futebol.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.giovane.futebol.dto.TeamRequestDto;
import com.giovane.futebol.dto.TeamResponseDto;
import com.giovane.futebol.model.Team;
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
    void post_201() throws Exception {
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
    void delete_byId_204() throws Exception {
        mockMvc.perform(delete("/api/v1/soccer/team/1"))
                .andExpect(status().isNoContent());

    }

    // CHECK
    @Test
    void find_ById_200() throws Exception {
        Mockito.when(teamService.findById(1)).thenReturn(Optional
                .of(new TeamResponseDto(1, "Internacional", "Beira-rio", "Brazil")));
        mockMvc.perform(get("/api/v1/soccer/team/1")).andExpect(status().isOk());
    }



//    @Test
//    public void find_ById_404() throws Exception {
//        Mockito.when(teamService.findById(1)).thenReturn(Optional
//                .of(new TeamResponseDto(1, "Internacional", "Beira-rio", "Brazil")));
//        Mockito.when(teamService.findById(1)).thenReturn(Optional.empty());
//        mockMvc.perform(get("/api/v1/soccer/team/3")).andExpect(status().isNotFound());
//    }



//
//    @Test
//    void put_204() throws Exception {
//
//        Team team = Team.builder()
//                .id(1)
//                .name("Internacional")
//                .stadium("Beira-rio")
//                .country("Brazil")
//                .build();
//
//        TeamRequestDto teamRequestDto = TeamRequestDto.builder()
//                .name("Barcelona")
//                .country("Spain")
//                .build();
//
//        Mockito.when(teamService.save(teamRequestDto)).thenReturn(teamRequestDto);
//
//
//        mockMvc.perform(put("/api/v1/soccer/team/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(teamRequestDto)))
//                .andExpect(status().isNoContent());
//    }
//



}