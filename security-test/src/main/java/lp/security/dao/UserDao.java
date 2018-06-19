package lp.security.dao;

import lp.security.domain.User;

/**
 * Created by lvpeng01 on 2018/6/13.
 */
public interface UserDao {

    User findByUserName(String username);

}
