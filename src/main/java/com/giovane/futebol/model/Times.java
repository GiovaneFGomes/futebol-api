package com.giovane.futebol.model;

import lombok.*;
import javax.validation.constraints.NotBlank;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Times {

    private Integer id;

    @NotBlank
    private String nome_time;

    @NotBlank
    private String nome_estadio;

    @NotBlank
    private String nome_estado;

}
