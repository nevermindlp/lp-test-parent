package lp;

public class ChildrenClass extends ParentClass {

    private String name;

    public String nameStr() {
        System.out.println(this.name);
        return this.name + "str";
    }

}
