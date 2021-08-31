package com.giovane.futebol.service;

import com.giovane.futebol.exceptions.NotFoundException;
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

    public Times save(Times time) {
        mapper.insert(time);
        return time;
    }

    public void updateTime(Times times, Integer id){
        Optional<Times> byId = mapper.findById(id);
        if (byId.isPresent()){
            times.setId(byId.get().getId());
            mapper.update(times);
        }else{
            throw new NotFoundException("Nao foi possivel atualizar time");
        }
    }

    public void deleteId(Integer timeId){
        mapper.deleteById(timeId);
    }

    public List<Times> select(){
        List<Times> times = mapper.findAll();
        return times;
    }

    public Times select2(Integer id){
        return mapper.findById(id)
                .orElseThrow(() -> new NotFoundException("Time não encontrado"));
    }

}
