package com.giovane.futebol.annotations;

import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TeamConstantsSwagger {

    public static final String TEAM_SAVE_SUMMARY = "Save a football team";
    public static final String TEAM_SAVE_DESCRIPTION = "This method save a football team";

    public static final String TEAM_PUT_SUMMARY= "Update a football team";
    public static final String TEAM_PUT_DESCRIPTION = "This method updates a football team";

    public static final String TEAM_DELETE_BY_ID_SUMMARY= "Delete a football team";
    public static final String TEAM_DELETE_BY_ID_DESCRIPTION = "This method deletes the football team";

    public static final String TEAM_FIND_ALL_SUMMARY = "Find all teams";
    public static final String TEAM_FIND_ALL_DESCRIPTION = "This method finds all teams in the database";

    public static final String TEAM_FIND_SUMMARY = "Find a single team";
    public static final String TEAM_FIND_DESCRIPTION = "This method find a single team in the database";

}
