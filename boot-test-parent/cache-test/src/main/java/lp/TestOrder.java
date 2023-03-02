package lp;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;

import lp.boot.cache.DateUtil;

/**
 * @author : lvpeng01
 * @since : 2020/6/13
 **/
@SpringBootApplication
public class TestOrder {

    @Bean
    public String test() {
        System.out.println("aaaa");
        return "aaa";
    }

    public static void main(String[] args) {
//        SpringApplication.run(TestOrder.class, args);
//        long keepDay = Math.round(3 * 30.4);
//        System.out.println(keepDay);

        Date yesterday = DateUtil.getDayBegin(new Date(), -1);
        Date selectDayBegin = DateUtil.getDayBeginByType(yesterday, 5);
        Date selectDayEnd = DateUtil.getDayEndByType(yesterday, 5);

        System.out.println( "begin is : " + selectDayBegin + " end is :" + selectDayEnd);
    }


    @Scheduled()
    public void task() {

    }

}
