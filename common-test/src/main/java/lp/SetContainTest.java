package lp;

import java.util.Set;

import com.google.common.collect.Sets;

/**
 * @author : lvpeng01
 * @since : 2021/4/7
 **/
public class SetContainTest {

    public static void main(String[] args) {
        Set<Integer> s = Sets.newHashSet(1,2,3);
        boolean contains = s.contains(null);
        System.out.println(contains);
    }
}
