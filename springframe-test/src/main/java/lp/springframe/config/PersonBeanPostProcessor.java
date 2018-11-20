package lp.springframe.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import lp.springframe.model.Person;

/**
 * Created by lvpeng01 on 2018/10/31.
 */
@Component
public class PersonBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Person) {
            System.out.println("postProcessBeforeInitialization ori val is " + bean);
            Person personBean = (Person) bean;
            personBean.setName("change before initialization.");
            personBean.setAge(999);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Person) {
            System.out.println("postProcessAfterInitialization ori val is " + bean);
            Person personBean = (Person) bean;
            personBean.setName("change after instantiation.");
            personBean.setAge(9999);
        }
        return bean;
    }
}
