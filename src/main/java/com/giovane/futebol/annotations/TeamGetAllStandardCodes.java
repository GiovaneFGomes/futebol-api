package com.giovane.futebol.annotations;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.giovane.futebol.annotations.TeamConstantsSwagger.*;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Shows all football teams"),
})
@Operation(summary = TEAM_FIND_ALL_SUMMARY, description = TEAM_FIND_ALL_DESCRIPTION)
public @interface TeamGetAllStandardCodes {

}
