package lp.extend;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : lvpeng01
 * @since : 2022/7/21
 **/
public class CommonTest {

    public static void main(String[] args) {

        Teacher t1 = new Teacher(30);
        Teacher t2 = new Teacher(35);

        Student s1 = new Student("no1", "A");
        Student s2 = new Student("no2", "B");

        List<BaseVo> l = new LinkedList<>();
        l.add(t1);
        l.add(t2);
        l.add(s1);
        l.add(s2);

        System.out.println(l.size());

        l.stream().map(baseVo -> {
            System.out.println(baseVo.getCode());
            return baseVo.getCode();
        }).collect(Collectors.toList());

    }

}
