package lp.boot.cache.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lp.boot.cache.db.model.UserDO;

/**
 * @author : lvpeng01
 * @since : 2020/6/13
 **/
public interface UserRepository extends JpaRepository<UserDO, Long> {
}
