package com.giovane.futebol.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Times {
    private Integer id;
    private String nome_time;
    private String nome_estadio;
    private String nome_estado;
}
