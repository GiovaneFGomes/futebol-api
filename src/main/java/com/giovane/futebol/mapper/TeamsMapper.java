package com.giovane.futebol.mapper;

import com.giovane.futebol.model.Teams;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Optional;

@Mapper
public interface TeamsMapper {

    // INSERT INTO teams (name_team, name_stadium, name_country) VALUES ('inter','beira-rio', 'brazil');

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert(value = " INSERT INTO teams (name_team, name_stadium, name_country)   " +
                    " VALUES ( #{teams.name, jdbcType=VARCHAR},                   " +
                    "         #{teams.stadium, jdbcType=VARCHAR},                 " +
                    "          #{teams.country, jdbcType=VARCHAR})                " )
    void insert(@Param("teams") Teams teams);

    @Update("UPDATE teams SET name_team=#{teams.name_team},name_stadium=#{teams.name_stadium},name_country=#{teams.name_country} WHERE id=#{teams.id};")
    void update(Teams teams);

    @Delete("DELETE FROM teams WHERE id=#{id};")
    void deleteById(Integer teamId);

    @Select("SELECT id AS id,name_team,name_stadium,name_country FROM teams")
    @Results(id = "teamResultId" , value ={
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name_team"),
            @Result(property = "stadium", column = "name_stadium"),
            @Result(property = "country", column = "name_country"),
    })
    List<Teams> findAll();

    @Select("SELECT * FROM teams WHERE id=#{id}")
    @ResultMap("teamResultId")
    Optional<Teams> findById(Integer id);

}
