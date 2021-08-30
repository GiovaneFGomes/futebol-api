package com.giovane.futebol.mapper;

import com.giovane.futebol.model.Times;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TimesMapper {

    @Insert("INSERT INTO times(id,nome_time,nome_estadio,nome_estado) VALUES (#{id},#{nome_time},#{nome_estadio},#{nome_estado});")
    void insert(Times times);

    @Update("UPDATE times SET nome_time=#{nome_time}, nome_estadio=#{nome_estadio}, nome_estado=#{nome_estado} WHERE id=#{id};")
    void update(Times times);

    @Delete("DELETE FROM times WHERE id=#{id};")
    void deleteById(Integer times);

    @Select("SELECT id AS id,nome_time,nome_estadio,nome_estado FROM times")
    List<Times> select();


}
