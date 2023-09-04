import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author : lvpeng01
 * @since : 2023/4/24
 **/
public class LinkedListTest {

    public static void main(String[] args) {

        float a = 0.1f;
        float b = 0.2f;
        float c = 0.3f;
        float d = 0.4f;
        float e = 0.5f;
        float f = 0.02f;

        List list = Lists.newArrayList();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);

        System.out.println(list);

    }

}
