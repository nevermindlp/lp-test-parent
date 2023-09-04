import java.util.ArrayList;
import java.util.List;

/**
 * @author : lvpeng01
 * @since : 2023/3/27
 **/
public class HeapOverflow {

    public static void main(String[] args) {
        int index = 1;
        for(String arg : args) {
            System.out.println("args index: " + index++ + " value is :" + arg);
        }

        List list = new ArrayList();
        int i = 0;
        while(true) {
            list.add(i++);
        }
    }
}
