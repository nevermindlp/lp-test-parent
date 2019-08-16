package lp.springframe.service.rollback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lvpeng01 on 2018/12/17.
 */
@Service
public class InvokeService {

    @Autowired
    private ExceptionService exceptionService;

    @Transactional
    public void invoke() {
        try {
            exceptionService.doMethod();
        } catch (RuntimeException e) {
            System.out.println("catch exception...");
        }
//        exceptionService.doMethod();
    }

}
