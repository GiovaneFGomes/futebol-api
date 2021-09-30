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
        @ApiResponse(responseCode = "201", description = "Team was created"),
        @ApiResponse(responseCode = "400", description = "An incorrect request has been sent")
})
@Operation(summary = TEAM_SAVE_SUMMARY, description = TEAM_SAVE_DESCRIPTION)
public @interface TeamSaveStandardsCodes {

}
