package com.giovane.futebol.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Teams {

    private Integer id;

    @NotNull
    @Size(min = 3, max = 40, message = "min 3 and max 40 characters")
    private String name;

    @NotNull
    @Size(min = 3, max = 50, message = "min 3 and max 50 characters")
    private String stadium;

    @NotNull
    @Size(min = 5, max = 50, message = "min 5 and max 50 characters")
    private String country;

}
