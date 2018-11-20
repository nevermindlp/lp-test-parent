package lp.springframe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lp.springframe.model.Person;

/**
 * Created by lvpeng01 on 2018/10/31.
 */
@Service
public class SchoolService {

    @Autowired
    private Person person;

    public void showInfo() {
        System.out.println("p.name is : " + person.getName() + "p.age is : " + person.getAge());
    }

}
