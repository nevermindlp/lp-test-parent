package lp.boot.cache.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lp.boot.cache.CommonCacheService;
import lp.boot.cache.db.model.UserDO;
import lp.boot.cache.db.repository.UserRepository;

/**
 *
 * spring boot test 会向上找@SpringBootApplication
 * 从里到外直到找到
 *
 * @author : lvpeng01
 * @since : 2020/6/13
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommonCacheService commonCacheService;

//    @Before
    public void before() {
        UserDO userDO = new UserDO();
        userDO.setAge(10);
        userDO.setName("lp");
        userRepository.save(userDO);
    }

    @Test
    public void getUser() throws InterruptedException {
        Long id = 2L;
        UserDO user = commonCacheService.getUser(id);
        System.out.println("1");
        System.out.println(user);

        user = commonCacheService.getUser(id);
        System.out.println("2");
        System.out.println(user);

        Thread.sleep(13000);

        user = commonCacheService.getUser(id);
        System.out.println("3");
        System.out.println(user);
    }

}
