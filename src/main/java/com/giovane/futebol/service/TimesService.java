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

    public Times save(Times times) {
        Optional<Times> timesUpdate = mapper.





    }
//        mapper.insert(times);
//        return times;






    public void update(Times times){
        mapper.update(times);
    }

    public void deleteId(Integer timeId){
        mapper.deleteById(timeId);

    }


    public List<Times> select(){
        List<Times> times = mapper.select();
        return times;
    }


}
