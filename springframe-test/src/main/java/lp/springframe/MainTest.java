package lp.springframe;

import java.io.File;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import lp.springframe.config.SpringConfig;
import lp.springframe.model.Person;
import lp.springframe.service.SchoolService;
import lp.springframe.util.ConfigUtil;

/**
 * Created by lvpeng01 on 2018/10/30.
 */
public class MainTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringConfig.class);
        context.refresh();
        Person person = context.getBean(Person.class);
        System.out.println(person);

        System.out.println("get key from app.conf file, test1 is : " + ConfigUtil.get("test1"));

        SchoolService schoolService = context.getBean(SchoolService.class);
        schoolService.showInfo();

//        Date d = new Date(1540977911644L);
//        System.out.println(d);

    }

}
