package com.yqjr.fin.mkmm.sales.services;

import com.netflix.discovery.converters.Auto;
import com.yqjr.fin.mkmm.sales.condition.EventPersonCondition;
import com.yqjr.fin.mkmm.sales.entity.EventPerson;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import java.util.List;

@Service
public class TeamPersonAndEvent {
    @Autowired
    private EventPersonService eventPersonService;

    @Transactional
public List<EventPerson> select(EventPersonCondition condition){
    return eventPersonService.selectT(condition);
}



    @Transactional
    public EventPerson selectById(Long id){
        return eventPersonService.selectById(id);
    }

    @Transactional
    public List<EventPerson> selectpersonCode(String personCode){
        EventPersonCondition eventPersonCondition=new EventPersonCondition();
        return eventPersonService.queryEventPerson(eventPersonCondition);
    }


    @Transactional
    public void  updateById(EventPerson eventPerson){
        eventPersonService.updateById(eventPerson);
    }

    @Transactional
    public void insertById(EventPerson eventPerson){
        eventPersonService.insert(eventPerson);
    }
}
