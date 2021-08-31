package com.giovane.futebol.mapper;
import com.giovane.futebol.model.Teams;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Optional;

@Mapper
public interface TeamsMapper {

    @Insert("INSERT INTO teams(name_team,name_stadium,name_country) VALUES (#{name_team},#{name_stadium},#{name_country});")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(Teams teams);

    @Update("UPDATE teams SET name_team=#{name_team}, name_stadium=#{name_stadium}, name_country=#{name_country} WHERE id=#{id};")
    void update(Teams teams);

    @Delete("DELETE FROM teams WHERE id=#{id};")
    void deleteById(Integer teamId);

    @Select("SELECT id AS id,name_team,name_stadium,name_country FROM teams")
    List<Teams> findAll();

    @Select("SELECT * FROM teams WHERE id=#{id}")
    Optional<Teams> findById(Integer id);

}
