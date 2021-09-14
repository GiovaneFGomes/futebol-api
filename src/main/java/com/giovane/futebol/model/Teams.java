package com.giovane.futebol.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Teams {
    private Integer id;
    private String name;
    private String stadium;
    private String country;
}
