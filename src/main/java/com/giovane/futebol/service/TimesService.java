package com.giovane.futebol.service;

import com.giovane.futebol.mapper.TimesMapper;
import com.giovane.futebol.model.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimesService {

    @Autowired
    TimesMapper mapper;

    public void save(Times times){
        this.mapper.insert(times);
    }

    public void update(Times times){
        this.mapper.update(times);
    }

    public void delete(Integer timeId){
        this.mapper.delete(timeId);
    }

    public List<Times> select(){
        List<Times> times = this.mapper.select();
        return times;
    }

    public Optional<Times> select2(Integer timeId) {
        return mapper.select2(timeId);
    }

}
