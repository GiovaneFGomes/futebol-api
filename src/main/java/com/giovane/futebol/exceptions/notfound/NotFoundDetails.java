package com.giovane.futebol.exceptions.notfound;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Map;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundDetails {

    private String title;
    private Integer status;
    private Map details;
    private Instant timestamp;
    private String developerMessage;


}
