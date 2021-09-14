package com.giovane.futebol.dto;

import com.giovane.futebol.model.Teams;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeamsResponseDto {

    private Integer id;
    private String name;
    private String stadium;
    private String country;


    // construtor que recebe dados da model
    public TeamsResponseDto(Teams teams) {
        this.id = teams.getId();
        this.name = teams.getName();
        this.stadium = teams.getStadium();
        this.country = teams.getCountry();
    }


}
