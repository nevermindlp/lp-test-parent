package lp.jackson;

/**
 * Created by lvpeng01 on 2018/9/4.
 */
public class Person {

    private String name;
    private Integer age;

    private Person() {}

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name + "set";
//    }

    public Integer getAge() {
        return age;
    }
//
//    public void setAge(Integer age) {
//        this.age = age + 100;
//    }
}
