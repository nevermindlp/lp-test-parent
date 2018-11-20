package lp.springframe.config;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import lp.springframe.annotation.CustomAnnotation;

/**
 * Created by lvpeng01 on 2018/10/30.
 */
@Component
public class PersonBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)
            throws BeansException {
        System.out.println("PersonBeanFactoryPostProcessor");

        // 提前实例化会导致 beanPostProcessor的hack不会执行
        Map<String, Object> beansWithAnnotation =
                configurableListableBeanFactory.getBeansWithAnnotation(CustomAnnotation.class);

//        String[] beanNamesForAnnotation =
//                configurableListableBeanFactory.getBeanNamesForAnnotation(CustomAnnotation.class);

        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("lp.springframe.model.Person");
        MutablePropertyValues mutablePropertyValues = beanDefinition.getPropertyValues();

        System.out.println("bean factory post ori val is : " + mutablePropertyValues.toString());
        mutablePropertyValues.addPropertyValue("name", "person-name");
        mutablePropertyValues.addPropertyValue("age", 99);

    }
}
