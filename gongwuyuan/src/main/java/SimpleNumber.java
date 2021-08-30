import java.text.DecimalFormat;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 随机生成两位整数x
 * 生成：
 *  x / 5，25，125 各10道
 *  x * 1.1，0.9 各10道
 * generate result to md for view.
 *
 * @author : lvpeng01
 * @since : 2020/9/15
 **/
public class SimpleNumber {

    private DecimalFormat df = new DecimalFormat();

    /*
     * distinct work well in infinite stream.
     */
    private IntStream generateRandom10Num() {
        Random random = new Random();
        return random.ints(10, 100).distinct().limit(10);
    }

    private void div5() {
        System.out.println("### generate 'x / 5'.");
        System.out.println("```");
        generateRandom10Num().forEach(n -> System.out.println(n + "/5" + "="));
        System.out.println("```");
    }

    private void div25() {
        System.out.println("### generate 'x / 25'.");
        System.out.println("```");
        generateRandom10Num().forEach(n -> System.out.println(n + "/25" + "="));
        System.out.println("```");
    }

    private void div125() {
        System.out.println("### generate 'x / 125'.");
        System.out.println("```");
        generateRandom10Num().forEach(n -> System.out.println(n + "/125" + "="));
        System.out.println("```");
    }

    private void mul11() {
        System.out.println("### generate 'x * 1.1'.");
        System.out.println("```");
        generateRandom10Num().forEach(n -> System.out.println(n + "*1.1" + "="));
        System.out.println("```");
    }

    private void mul09() {
        System.out.println("### generate 'x * 0.9'.");
        System.out.println("```");
        generateRandom10Num().forEach(n -> System.out.println(n + "*0.9" + "="));
        System.out.println("```");
    }

    public static void main(String[] args) {
        SimpleNumber simpleNumber = new SimpleNumber();
        simpleNumber.div5();
        System.out.println("--------------");
        simpleNumber.div25();
        System.out.println("--------------");
        simpleNumber.div125();
        System.out.println("--------------");
        simpleNumber.mul09();
        System.out.println("--------------");
        simpleNumber.mul11();
    }
}
