package lp.springframe.model;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

import lp.springframe.annotation.CustomAnnotation;

/**
 * Created by lvpeng01 on 2018/10/30.
 */
@CustomAnnotation(key = "c-key", value = "c-value")
@Component
public class Person {

    public Person() {
        this.name = "constructor val";
        this.age = 9;
        System.out.println("person none param constructor.");
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @PostConstruct
    public void init() {
        System.out.println("person init method.");
        this.name = "init name val";
        this.age = 10;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("age", age)
                .toString();
    }
}
