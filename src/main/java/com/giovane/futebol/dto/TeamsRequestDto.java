package com.giovane.futebol.dto;

import com.giovane.futebol.model.Teams;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeamsRequestDto {

    private Integer id;

    @NotBlank
    @Size(min = 3, max = 40, message = "min 3 and max 40 characters")
    private String name;

    @NotBlank
    @Size(min = 3, max = 50, message = "min 3 and max 50 characters")
    private String stadium;

    @NotBlank
    @Size(min = 5, max = 50, message = "min 5 and max 50 characters")
    private String country;


    // construtor que recebe dados da model
    public TeamsRequestDto(Teams teams) {
        this.id = teams.getId();
        this.name = teams.getName();
        this.stadium = teams.getStadium();
        this.country = teams.getCountry();
    }

    public void setName(String name) {
        this.name = name.strip();
    }

    public void setStadium(String stadium) {
        this.stadium = stadium.strip();
    }

    public void setCountry(String country) {
        this.country = country.strip();
    }

}
