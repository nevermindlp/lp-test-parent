package lp.npe;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * Created by lvpeng01 on 2018/8/28.
 */
public class ArrayListAddNull {

    @Test
    public void testListAdd() {
        List<String> list = Lists.newArrayList();
        list.add(null);
        list.add(null);
        System.out.println(list.size());
    }

}
