package lp.schedule.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author : lvpeng01
 * @since : 2023/7/17
 **/
@Service
public class MySchedule {

    @Scheduled(cron = "0 49 9 * * ?")
    public void schedule1() {
        System.out.println("schedule 1 is running.");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("schedule 1 is finished.");
    }

    @Scheduled(cron = "0 49 9 * * ?")
    public void schedule2() {
        System.out.println("schedule 2 is running.");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("schedule 2 is finished.");
    }

}
