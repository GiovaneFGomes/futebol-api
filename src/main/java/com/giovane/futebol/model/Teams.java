package com.giovane.futebol.model;

import lombok.*;
import javax.validation.constraints.NotBlank;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teams {

    private Integer id;

    @NotBlank
    private String name_team;

    @NotBlank
    private String name_stadium;

    @NotBlank
    private String name_country;

}
