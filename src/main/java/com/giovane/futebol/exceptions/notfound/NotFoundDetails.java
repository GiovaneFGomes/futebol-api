package com.giovane.futebol.exceptions.notfound;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import java.time.Instant;


@SuperBuilder
@Data
public class NotFoundDetails {

    private Integer status;
    private String title;
    private Instant timestamp;
    private String details;
    private String developerMessage;

}
