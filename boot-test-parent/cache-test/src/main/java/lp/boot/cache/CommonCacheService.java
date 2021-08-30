package lp.boot.cache;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lp.boot.cache.db.model.UserDO;
import lp.boot.cache.db.repository.UserRepository;

/**
 * @author : lvpeng01
 * @since : 2020/6/13
 **/
@Service
public class CommonCacheService {

    @Autowired
    private UserRepository userRepository;

    @Cacheable(value = "a-cache")
//    @Transactional
    public UserDO getUser(Long id) {
        // getOne need Transactional annotation. omg......
        return userRepository.findById(id).orElse(null);

    }

}
