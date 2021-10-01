package com.giovane.futebol.mapper;

import com.giovane.futebol.model.dto.TeamResponseDto;
import com.giovane.futebol.model.Team;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Optional;

@Mapper
public interface TeamMapper {

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert(value = "INSERT INTO teams (name_team, name_stadium, name_country)    " +
            "        VALUES (#{team.name, jdbcType=VARCHAR},                      " +
            "                #{team.stadium, jdbcType=VARCHAR},                   " +
            "                #{team.country, jdbcType=VARCHAR})                   " )
    void insert(@Param("team") Team team);

    @Update(value = " UPDATE teams                                         " +
            " SET    name_team=#{team.name, jdbcType=VARCHAR},             " +
            "        name_stadium=#{team.stadium, jdbcType=VARCHAR},       " +
            "        name_country=#{team.country, jdbcType=VARCHAR}        " +
            " WHERE  id=#{team.id};                                        " )
    void update(@Param("team") Team team);

    @Select("SELECT id AS id, name_team, name_stadium, name_country FROM teams")
    @Results(id = "teamResultId" , value ={
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name_team"),
            @Result(property = "stadium", column = "name_stadium"),
            @Result(property = "country", column = "name_country"),
    })
    List<TeamResponseDto> findAll();

    @Select("SELECT * FROM teams WHERE id=#{id}")
    @ResultMap("teamResultId")
    Optional<TeamResponseDto> findById(Integer id);

    @Delete("DELETE FROM teams WHERE id=#{id};")
    void deleteById(Integer team);

}
