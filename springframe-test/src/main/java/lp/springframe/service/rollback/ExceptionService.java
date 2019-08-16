package lp.springframe.service.rollback;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lvpeng01 on 2018/12/17.
 */
@Service
public class ExceptionService {

    @Transactional
    public void doMethod() {
        throw new RuntimeException("exception test");
    }

}
