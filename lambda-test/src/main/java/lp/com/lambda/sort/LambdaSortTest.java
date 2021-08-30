package lp.com.lambda.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : lvpeng01
 * @since : 2020/11/2
 **/
public class LambdaSortTest {


    private static List<TestVo> initList = new ArrayList<>();
    private static int limitNum = 2;

    static {
        TestVo testVo1 = new TestVo("213", "1603105655000");
        TestVo testVo2 = new TestVo("13", "1603102726000");
        TestVo testVo3 = new TestVo("219", "1603103315000");

        TestVo testVo4 = new TestVo("219", "1603104342000");
        TestVo testVo5 = new TestVo("13", "1603102767000");
        TestVo testVo6 = new TestVo("211", "1603103161000");

        TestVo testVo7 = new TestVo("219", "1603103295000");
        TestVo testVo8 = new TestVo("97", "1603104822000");

        initList.add(testVo1);
        initList.add(testVo2);
        initList.add(testVo3);
        initList.add(testVo4);
        initList.add(testVo5);
        initList.add(testVo6);
        initList.add(testVo7);
        initList.add(testVo8);

    }

    public static void main(String[] args) {

        Map<String, List<TestVo>> result = new TreeMap<>();

        Map<String, List<TestVo>> collect = initList.stream().collect(Collectors.groupingBy(TestVo::getCameraId));

        List<String> sortedCameraId =
                collect.keySet().stream().sorted((o1, o2)
                        -> (int) (Long.parseLong(o2) - Long.parseLong(o1))).collect(Collectors.toList());

        sortedCameraId.forEach(cameraId -> {
            List<TestVo> collect1 = collect.get(cameraId).stream()
                    .sorted((o1, o2) -> Math.toIntExact(Long.parseLong(o1.getSnapshotTime())
                            - Long.parseLong(o2.getSnapshotTime())))
                    .limit(limitNum).collect(Collectors.toList());
            result.put(cameraId, collect1);
        });
        System.out.println(result);
    }

}
