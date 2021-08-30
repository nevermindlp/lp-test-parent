package lp.boot.cache.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

/**
 * @author guhong
 * @date 2019/5/13
 */
@Configuration
@EnableJpaRepositories(basePackages = {"lp.boot.cache.db.repository"})
public class JpaConfig {

}
