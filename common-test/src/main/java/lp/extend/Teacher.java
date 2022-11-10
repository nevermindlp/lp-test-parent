package lp.extend;

/**
 * @author : lvpeng01
 * @since : 2022/7/21
 **/
public class Teacher extends BaseVo {

    public Teacher() {
    }

    public Teacher(Integer age) {
        this.age = age;
    }

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
