package lp.lambda.compareMax;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * Created by lvpeng01 on 2019/3/26.
 */
public class CompareMaxTest {

    private Comparator<CompareWrapperVo> resourceComparator
            = (r1, r2) -> getResourceWeight(r1.getCompareVoList()) - getResourceWeight(r2.getCompareVoList());

    private int getResourceWeight(List<CompareVo> compareVos) {
        if (null == compareVos) {
            return 0;
        }
        return compareVos.stream().mapToInt(compareVo -> {
            return compareVo.getNum() * compareVo.getWeight();
        }).sum();
    }

    @Test
    public void pick() {
        List<CompareWrapperVo> compareWrapperVos = Lists.newArrayList();

        CompareWrapperVo compareWrapperVo1 = new CompareWrapperVo();
        List<CompareVo> compareVoList1 = Lists.newArrayList();
        CompareVo compareVo11 = new CompareVo(2, 10);
        CompareVo compareVo12 = new CompareVo(1, 10);
        CompareVo compareVo13 = new CompareVo(60, 5);
        compareVoList1.add(compareVo11);
        compareVoList1.add(compareVo12);
        compareVoList1.add(compareVo13);
        compareWrapperVo1.setCompareVoList(compareVoList1);
        compareWrapperVos.add(compareWrapperVo1);

        CompareWrapperVo compareWrapperVo2 = new CompareWrapperVo();
        List<CompareVo> compareVoList2 = Lists.newArrayList();
        CompareVo compareVo21 = new CompareVo(0, 10);
        CompareVo compareVo22 = new CompareVo(1, 10);
        CompareVo compareVo23 = new CompareVo(60, 5);
        compareVoList2.add(compareVo21);
        compareVoList2.add(compareVo22);
        compareVoList2.add(compareVo23);
        compareWrapperVo2.setCompareVoList(compareVoList2);
        compareWrapperVos.add(compareWrapperVo2);

        CompareWrapperVo compareWrapperVo3 = new CompareWrapperVo();
        List<CompareVo> compareVoList3 = Lists.newArrayList();
        CompareVo compareVo31 = new CompareVo(1, 10);
        CompareVo compareVo32 = new CompareVo(1, 10);
        CompareVo compareVo33 = new CompareVo(60, 5);
        compareVoList3.add(compareVo31);
        compareVoList3.add(compareVo32);
        compareVoList3.add(compareVo33);
        compareWrapperVo3.setCompareVoList(compareVoList3);
        compareWrapperVos.add(compareWrapperVo3);

//        CompareWrapperVo compareWrapperVo4 = new CompareWrapperVo();
//        List<CompareVo> compareVoList4 = Lists.newArrayList();
//        CompareVo compareVo41 = new CompareVo(0, 10);
//        CompareVo compareVo42 = new CompareVo(1, 10);
//        CompareVo compareVo43 = new CompareVo(60, 5);
//        compareVoList4.add(compareVo41);
//        compareVoList4.add(compareVo42);
//        compareVoList4.add(compareVo43);
//        compareWrapperVo4.setCompareVoList(compareVoList4);
//        compareWrapperVos.add(compareWrapperVo4);

        Optional<CompareWrapperVo> max = compareWrapperVos.stream().max(resourceComparator);
        if (max.isPresent()) {
            System.out.println(max.get());
        }
    }

}
