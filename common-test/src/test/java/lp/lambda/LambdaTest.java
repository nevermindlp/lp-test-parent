package lp.lambda;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

/**
 * Created by lvpeng01 on 2018/8/21.
 */
public class LambdaTest {

    private static List<PersonInfo> attributes = Lists.newArrayList();

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeClass
    public static void startUp() {
        PersonInfo personInfo1 = new PersonInfo();
        personInfo1.setCode("test1");
        personInfo1.setLength(10);
        personInfo1.setWight(10);
        List<String> attrInfo1 = Lists.newArrayList();
        attrInfo1.add(PersonInfo.DirectionEnum.ASC.name());
        attrInfo1.add(PersonInfo.TruncationEnum.UPPER.name());
        attrInfo1.add(PersonInfo.OcclusionEnum.NONE.name());
        personInfo1.setAttrInfoList(attrInfo1);
        attributes.add(personInfo1);

        PersonInfo personInfo2 = new PersonInfo();
        personInfo2.setCode("test2");
        personInfo2.setLength(10);
        personInfo2.setWight(20);
        List<String> attrInfo2 = Lists.newArrayList();
        attrInfo2.add(PersonInfo.DirectionEnum.ASC.name());
        attrInfo2.add(PersonInfo.TruncationEnum.SIDE.name());
        attrInfo2.add(PersonInfo.OcclusionEnum.SERIOUS.name());
        personInfo2.setAttrInfoList(attrInfo2);
        attributes.add(personInfo2);


        PersonInfo personInfo3 = new PersonInfo();
        personInfo3.setCode("test3");
        personInfo3.setLength(10);
        personInfo3.setWight(30);
        List<String> attrInfo3 = Lists.newArrayList();
        attrInfo3.add(PersonInfo.DirectionEnum.ASC.name());
//        attrInfo3.add(PersonInfo.TruncationEnum.UPPER.name());
        attrInfo3.add(PersonInfo.OcclusionEnum.MILD.name());
        personInfo3.setAttrInfoList(attrInfo3);
        attributes.add(personInfo3);


        PersonInfo personInfo4 = new PersonInfo();
        personInfo4.setCode("test4");
        personInfo4.setLength(10);
        personInfo4.setWight(40);
        List<String> attrInfo4 = Lists.newArrayList();
        attrInfo4.add(PersonInfo.DirectionEnum.DESC.name());
        attrInfo4.add(PersonInfo.TruncationEnum.UPPER.name());
        attrInfo4.add(PersonInfo.OcclusionEnum.SERIOUS.name());
        personInfo4.setAttrInfoList(attrInfo4);
        attributes.add(personInfo4);


        PersonInfo personInfo5 = new PersonInfo();
        personInfo5.setCode("test5");
        personInfo5.setLength(10);
        personInfo5.setWight(50);
        List<String> attrInfo5 = Lists.newArrayList();
        attrInfo5.add(PersonInfo.DirectionEnum.DESC.name());
        attrInfo5.add(PersonInfo.TruncationEnum.LOW.name());
        attrInfo5.add(PersonInfo.OcclusionEnum.SERIOUS.name());
        personInfo5.setAttrInfoList(attrInfo5);
        attributes.add(personInfo5);

    }

    @Test
    public void test() throws JsonProcessingException {
        Map<PersonInfo.DirectionEnum, PersonInfo> pickOne = attributes.parallelStream()
                .collect(groupingBy(directionPick, collectingAndThen(truncationPick, Function.identity())));
        pickOne.forEach((k, v) -> {
            if (v == null) {
                return;
            }
            System.out.println(v.getCode());
        });
        System.err.println("pickOne result is " + objectMapper.writeValueAsString(pickOne));
    }

    private Collector<PersonInfo, List<PersonInfo>, PersonInfo>
            truncationPick =
            new Collector<PersonInfo, List<PersonInfo>, PersonInfo>() {
                @Override
                public Supplier<List<PersonInfo>> supplier() {
                    return ArrayList::new;
                }

                @Override
                public BiConsumer<List<PersonInfo>, PersonInfo> accumulator() {
                    return  (List<PersonInfo> list, PersonInfo p) -> {
                        System.out.println("----- accumulator -----" + p.getCode());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        list.add(p);
                    };
                }

                @Override
                public BinaryOperator<List<PersonInfo>> combiner() {
                    return (list1, list2) -> {
                        System.out.println("list1 info :" + listPrint(list1) + "list2 info : " + listPrint(list2));
                        list1.addAll(list2);
                        return list1;
                    };
                }

                @Override
                public Function<List<PersonInfo>, PersonInfo> finisher() {
                    return qualityPickFunction;
                }

//                @Override
//                public Set<Characteristics> characteristics() {
//                    return Collections.emptySet();
//                }
                @Override
                public Set<Characteristics> characteristics() {
                    return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
                }
            };

    private Predicate<PersonInfo> noneOcclusion = t -> {
        List<String> attrInfoList = t.getAttrInfoList();
        for (String attrInfo : attrInfoList) {
            if (PersonInfo.OcclusionEnum.NONE.name().equals(attrInfo)) {
                return true;
            }
        }
        return false;
    };

    private Predicate<PersonInfo> mildOcclusion = t -> {
        List<String> attrInfoList = t.getAttrInfoList();
        for (String attrInfo : attrInfoList) {
            if (PersonInfo.OcclusionEnum.MILD.name().equals(attrInfo)) {
                return true;
            }
        }
        return false;
    };

    private Predicate<PersonInfo> seriousOcclusion = t -> {
        List<String> attrInfoList = t.getAttrInfoList();
        for (String attrInfo : attrInfoList) {
            if (PersonInfo.OcclusionEnum.SERIOUS.name().equals(attrInfo)) {
                return true;
            }
        }
        return false;
    };

    private Function<PersonInfo, Integer> sizePick = t ->
            t.getLength() * t.getWight();

    private Function<List<PersonInfo>, PersonInfo> qualityPickFunction =
            (list) -> {
                // 截断判断
                List<PersonInfo> truncationList = list.stream().filter(t -> {
                    List<String> attrList = t.getAttrInfoList();
                    boolean upperTrunc = true;
                    boolean lowerTrunc = true;
                    boolean sideTrunc = true;
                    boolean containsTruncation = false;
                    for (String attrInfo : attrList) {
                        for (PersonInfo.TruncationEnum truncationEnum : PersonInfo.TruncationEnum.values()) {
                            if (truncationEnum.name().equals(attrInfo)) {
                                containsTruncation = true;
                            }
                        }
                        if (PersonInfo.TruncationEnum.LOW.name().equals(attrInfo)
                                || PersonInfo.TruncationEnum.SIDE.name().equals(attrInfo)) {
                            upperTrunc = false;
                        }
                        if (PersonInfo.TruncationEnum.UPPER.name().equals(attrInfo)
                                || PersonInfo.TruncationEnum.SIDE.name().equals(attrInfo)) {
                            lowerTrunc = false;
                        }
                        if (PersonInfo.TruncationEnum.UPPER.name().equals(attrInfo)
                                || PersonInfo.TruncationEnum.LOW.name().equals(attrInfo)) {
                            sideTrunc = false;
                        }
                        if (!upperTrunc && !lowerTrunc && !sideTrunc) {
                            return true;
                        }
                    }
                    return !containsTruncation;
                }).collect(toList());
                if (CollectionUtils.isEmpty(truncationList)) {
                    // 所有数据都有截断,从原列表中判断遮挡
//                    truncationList = list;
                    return null;
                }

                // 遮挡判断
                List<PersonInfo> occlusionList =
                        truncationList.stream().filter(noneOcclusion).collect(toList());
                if (CollectionUtils.isEmpty(occlusionList)) {
                    // 所有数据都有遮挡
                    occlusionList = truncationList.stream().filter(mildOcclusion).collect(toList());
                }
                if (CollectionUtils.isEmpty(occlusionList)) {
                    // 所有数据重度遮挡
                    occlusionList = truncationList.stream().filter(seriousOcclusion).collect(toList());
                }
                // 尺寸判断
                return occlusionList.stream().max(Comparator.comparing(sizePick)).orElse(null);
            };

    private Function<PersonInfo, PersonInfo.DirectionEnum> directionPick = t -> {
        for (String attrInfo : t.getAttrInfoList()) {
            for (PersonInfo.DirectionEnum d : PersonInfo.DirectionEnum.values()) {
                if (d.name().equals(attrInfo)) {
                    return d;
                }
            }
        }
        return PersonInfo.DirectionEnum.OTHER;
    };

    private String listPrint(List<PersonInfo> list) {
        final String[] info = {""};
        list.forEach(p -> info[0] += p.getCode() + " ");
        return info[0];
    }

}
