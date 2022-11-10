package lp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : lvpeng01
 * @since : 2021/12/20
 **/
public class LinkedListTest {

    public static void main(String[] args) {

        List<Long> frequency = new LinkedList<>();

        frequency.add(0, 1L);
        frequency.add(0, 2L);
        frequency.add(0, 3L);
        System.out.println(frequency.size());

    }

}
