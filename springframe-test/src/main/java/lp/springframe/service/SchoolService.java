package lp.springframe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lp.springframe.model.Person;
import lp.springframe.service.rollback.ExceptionService;
import lp.springframe.service.rollback.InvokeService;

/**
 * Created by lvpeng01 on 2018/10/31.
 */
@Service
public class SchoolService {

    @Autowired
    private Person person;

    @Autowired
    private InvokeService invokeService;

    public void showInfo() {
        System.out.println("p.name is : " + person.getName() + "p.age is : " + person.getAge());
    }

    public void exceptionRollback() {
        invokeService.invoke();
    }

}
