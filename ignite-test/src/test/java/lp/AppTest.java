package lp;

import static java.util.stream.Collectors.groupingBy;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void arrayTest() {
//        String[] array = new String[]{""};

        String[] array = new String[1];
        array[0] = "123";

        System.out.println(array[0]);

    }

    @Test
    public void groupingByTest() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("f");

        Map<MyEnum, List<String>> collect = list.stream().collect(groupingBy(group));
        System.out.println(collect);
    }

    private Function<String, MyEnum> group = t -> {

        for (MyEnum e : MyEnum.values()) {
            if (e.name().equalsIgnoreCase(t)) {
                return e;
            }
        }
        return null;
    };

    public enum  MyEnum {
        A, B, C, D
    }


    @Test
    public void sortTest() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(1);

        System.out.println(list.stream().sorted((o1, o2) -> o2 - o1).findFirst());

        System.out.println(list);
    }

    @Test
    public void matchTest() {
        String tar = "sfg_user_collection_1532332376960";
        System.out.println(tar.matches("^[0-9a-zA-Z_]{0,50}$"));
    }

    @Test
    public void testByteArraySerialize() {

        ObjectMapper om = new ObjectMapper();
        String str = "hello, world";
        byte[] strArray = str.getBytes();
        System.out.println(new String(strArray));
        try {
            String serializeValue = om.writeValueAsString(strArray);
            System.out.println("serializeValue is : " + serializeValue);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
