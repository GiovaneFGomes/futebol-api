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
        @ApiResponse(responseCode = "204", description = "The football team has been deleted"),
        @ApiResponse(responseCode = "400", description = "An incorrect request has been sent"),
        @ApiResponse(responseCode = "404", description = "Team's ID does not exist")
})
@Operation(summary = TEAM_DELETE_BY_ID_SUMMARY, description = TEAM_DELETE_BY_ID_DESCRIPTION)
public @interface TeamDeleteStandardCodes {

}
