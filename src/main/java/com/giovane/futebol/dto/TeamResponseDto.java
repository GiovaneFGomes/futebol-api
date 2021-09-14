package com.giovane.futebol.dto;

import com.giovane.futebol.model.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeamResponseDto {

    private Integer id;
    private String name;
    private String stadium;
    private String country;

    public TeamResponseDto(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.stadium = team.getStadium();
        this.country = team.getCountry();
    }

}
