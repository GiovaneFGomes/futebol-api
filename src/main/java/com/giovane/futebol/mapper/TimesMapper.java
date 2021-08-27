package com.giovane.futebol.mapper;

import com.giovane.futebol.model.Times;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TimesMapper {
    @Insert("INSERT INTO times(id,nome_time,nome_estadio,nome_estado) VALUES (#{id},#{nome_time},#{nome_estadio},#{nome_estado});")
    public void insert(Times times);

    @Update("UPDATE times SET nome_time=#{nome_time}, nome_estadio=#{nome_estadio}, nome_estado=#{nome_estado} WHERE id=#{id};")
    public void update(Times times);

    @Delete("DELETE FROM times WHERE id=#{id};")
    public void delete(Integer times);

    @Select("SELECT id AS id,nome_time,nome_estadio,nome_estado FROM times")
    public List<Times> select();

    @Select("SELECT id AS id,nome_time,nome_estadio,nome_estado FROM times")
    public Optional<Times> select2(Integer timeId);


}
