package com.giovane.futebol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Times {
    private Integer id;
    private String nome_time;
    private String nome_estadio;
    private String nome_estado;
}
