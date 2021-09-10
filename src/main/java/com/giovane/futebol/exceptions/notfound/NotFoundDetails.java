package com.giovane.futebol.exceptions.notfound;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundDetails {

    private String title;
    private Integer status;
    private String details;
    private Instant timestamp;
    private String developerMessage;

}
