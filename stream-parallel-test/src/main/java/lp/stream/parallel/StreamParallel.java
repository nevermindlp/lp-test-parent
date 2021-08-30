package lp.stream.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StopWatch;

/**
 * @author : lvpeng01
 * @since : 2020/11/9
 **/
public class StreamParallel {

    static List<Vo> voList = new ArrayList<>();
    static {
        Vo vo1 = new Vo(10, "vo1");
        Vo vo2 = new Vo(12, "vo2");
        Vo vo3 = new Vo(13, "vo3");
        Vo vo4 = new Vo(0, "vo4");
        Vo vo5 = new Vo(10, "vo5");
        Vo vo6 = new Vo(12, "vo6");
        Vo vo7 = new Vo(13, "vo7");
        Vo vo8 = new Vo(0, "vo8");
        Vo vo9 = new Vo(0, "vo9");
        voList.add(vo1);
        voList.add(vo2);
        voList.add(vo3);
        voList.add(vo4);
        voList.add(vo5);
        voList.add(vo6);
        voList.add(vo7);
        voList.add(vo8);
        voList.add(vo9);
    }


    public static void main(String[] args) {
//        StopWatch stopWatch = new StopWatch("stream parallel");
//        stopWatch.start("ten times convert");
//        List<Vo> collect =
//                voList.stream().parallel()
//                        .map(StreamParallel::convertTenTimes)
//                        .filter(i -> i.getAge() != 0)
//                        .collect(Collectors.toList());
//        stopWatch.stop();
//        System.out.println("collect size is " + collect.size());
//        System.out.println(stopWatch.prettyPrint());

        List<Vo> collect = voList.stream().filter(vo -> {
            return vo.getAge() != 10;
        }).collect(Collectors.toList());
        System.out.println(collect);

    }

    private static Vo convertTenTimes(Vo vo) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Vo(vo.getAge() * 10, vo.getName());
    }

    public static class Vo {

        public Vo(int age, String name) {
            this.age = age;
            this.name = name;
        }

        int age;
        String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
