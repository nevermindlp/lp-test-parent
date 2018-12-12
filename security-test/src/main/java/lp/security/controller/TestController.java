package lp.security.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lp.security.vo.Vo;

/**
 * Created by lvpeng01 on 2018/12/3.
 */
@RestController
public class TestController {

    @RequestMapping(value = {"/lp"})
    public Vo index(){
        Vo v = new Vo();
        v.setAge(10);
        v.setName("lp");
        return v;
    }
}
