package com.giovane.futebol.exceptions.notfound;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.Map;

@SuperBuilder
@Getter
@Setter
public class ErrorDetails{
    private String title;
    private Integer status;
    private Instant timestamp;
    private String developerMessage;
    private Map<String,String> detailsErrors;

}
