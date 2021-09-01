package com.giovane.futebol.model;

import lombok.*;
import javax.validation.constraints.NotBlank;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teams {

    private Integer id;

    @NotBlank(message = "The name_team field cannot be blank")
    private String name_team;

    @NotBlank(message = "The name_stadium field cannot be blank")
    private String name_stadium;

    @NotBlank(message = "The name_country field cannot be blank")
    private String name_country;

}
