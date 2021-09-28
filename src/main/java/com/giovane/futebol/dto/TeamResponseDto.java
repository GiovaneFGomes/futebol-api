package com.giovane.futebol.dto;

import com.giovane.futebol.model.Team;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class TeamResponseDto extends Team {

    @Schema(example = "1")
    private Integer id;

    @Schema(example = "Real Madrid")
    private String name;

    @Schema(example = "Santiago Bernabéu")
    private String stadium;

    @Schema(example = "Spain")
    private String country;

    public TeamResponseDto(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.stadium = team.getStadium();
        this.country = team.getCountry();
    }

}
