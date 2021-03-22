package com.ainura.spr_mvc.dao;

import com.ainura.spr_mvc.models.People;
import com.ainura.spr_mvc.repo.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PeopleDao {
    @Autowired
    private  PeopleRepository people;


    public  List<People> index(){
        return  people.findAll();
    }

    public People show(long id){
        People d=people.getOne(id);
        return (d) ;

    }
    public void save(People people){

        this.people.save(people);
    }
    public void update(People people, long id)
    {
        People toBeUpd=this.people.getOne(id);
        toBeUpd.setName(people.getName());
        this.people.save(toBeUpd);

    }

    public void delete(Long id)
    {
        people.deleteById(id);

    }
}
