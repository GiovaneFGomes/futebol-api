package dto;

import entity.Team;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TeamRequest {
    @Schema(hidden = true)
    private Integer id;

    @NotBlank
    @Size(min = 3, max = 40, message = "Min 3 and Max 40 characters.")
    @Schema(description = "This is a football team's name", example = "Real Madrid")
    private String name;

    @NotBlank
    @Size(min = 3, max = 50, message = "Min 3 and Max 40 characters.")
    @Schema(description = "This is a football team's name stadium", example = "Santiago Bernabéu")
    private String stadium;

    @NotBlank
    @Size(min = 3, max = 50, message = "Min 3 and Max 40 characters.")
    @Schema(description = "This is a football team's name country", example = "Spain")
    private String country;

    public TeamRequest(Team teams) {
        this.id = teams.getId();
        this.name = teams.getName();
        this.stadium = teams.getStadium();
        this.country = teams.getCountry();
    }

    public Team createTeam(TeamRequest team){
        return Team.builder()
                .name(team.getName())
                .stadium(team.getStadium())
                .country(team.getCountry())
                .build();
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
