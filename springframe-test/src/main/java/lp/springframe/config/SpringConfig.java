package lp.springframe.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

import lp.springframe.model.Person;
import lp.springframe.service.SchoolService;

/**
 * Created by lvpeng01 on 2018/10/30.
 */
@Configuration
@ComponentScan(basePackageClasses = SchoolService.class)
@Import({Person.class, PersonBeanFactoryPostProcessor.class, PersonBeanPostProcessor.class})
@EnableTransactionManagement
public class SpringConfig {

    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/lp-test?characterEncoding=utf8&useSSL=true");
        ds.setUsername("root");
        ds.setPassword("123456");
        ds.setInitialSize(5);
        return ds;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
