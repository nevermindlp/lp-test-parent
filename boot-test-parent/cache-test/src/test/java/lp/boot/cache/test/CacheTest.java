package lp.boot.cache.test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

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
@EnableTransactionManagement
@SpringBootTest
public class CacheTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommonCacheService commonCacheService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

//    @Before
//    public void before() {
//        UserDO userDO = new UserDO();
//        userDO.setAge(10);
//        userDO.setName("lp");
//        userRepository.save(userDO);
//    }

//    @Test
//    public void getUser() throws InterruptedException {
//        Long id = 2L;
//        UserDO user = commonCacheService.getUser(id);
//        System.out.println("1");
//        System.out.println(user);
//
//        user = commonCacheService.getUser(id);
//        System.out.println("2");
//        System.out.println(user);
//
//        Thread.sleep(13000);
//
//        user = commonCacheService.getUser(id);
//        System.out.println("3");
//        System.out.println(user);
//    }

    @Test
    public void testJdbcSelect() {

        try {
            Connection connection = dataSource.getConnection();
            String sql = "select * from `arch_pictures` where id = 1559868890817146880";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BigDecimal id = resultSet.getBigDecimal("id");
                System.out.println(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    @Rollback(false)
    @Transactional
    public void testJdbcInsert() {

//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PERSISTENCE");
//        EntityManager entityManager1 = factory.createEntityManager();

//        Query nativeQuery = entityManager
//                .createNativeQuery("update arch_document_all set pic_number=18 where id=2");
//        int i = nativeQuery.executeUpdate();

//        entityManager.getTransaction().commit();
//        System.out.println("i" + i);
//        List resultList = nativeQuery.getResultList();
//        System.out.println("resultList size " + resultList.size());
//        String sql = "update arch_document_all set pic_number=? where id=?";
//        jdbcTemplate.update(sql, 19, 2);


        String sql = "select * from arch_document_all";
        jdbcTemplate.execute(sql);

//        String insertSql = "insert into arch_document_all (id, statistic, "
//                + "pic_number, person_id, person_no, rep_id_list, real_time, "
//                + "cover_id, create_time, update_time) "
//                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        jdbcTemplate.update(insertSql, 12, "sta", 2, 3, "p1", "1,2", 12, 1, 5, 6);



//        try {
//            Connection connection = dataSource.getConnection();
//            String sql = "select * from `arch_pictures` where id = 1559868890817146880";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                BigDecimal id = resultSet.getBigDecimal("id");
//                System.out.println(id);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }

}
