package com.giovane.futebol.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Teams {

    private Integer id;

    @Size(min = 3, max = 40, message = "min 3 and max 40 characters")
    private String name;

    @Size(min = 3, max = 50, message = "min 3 and max 50 characters")
    private String stadium;

    @Size(min = 5, max = 50, message = "min 5 and max 50 characters")
    private String country;


    public void setName(String name) {
        this.name = name.trim();
    }

    public void setStadium(String stadium) {
        this.stadium = stadium.trim();
    }

    public void setCountry(String country) {
        this.country = country.trim();
    }
}
