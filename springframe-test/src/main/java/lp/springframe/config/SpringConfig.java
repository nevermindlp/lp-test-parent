package lp.springframe.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import lp.springframe.model.Person;
import lp.springframe.service.SchoolService;

/**
 * Created by lvpeng01 on 2018/10/30.
 */
@Configuration
@ComponentScan(basePackageClasses = SchoolService.class)
@Import({Person.class, PersonBeanFactoryPostProcessor.class, PersonBeanPostProcessor.class})
public class SpringConfig {

//    @Bean
//    public Person person() {
//        return new Person();
//    }

}
