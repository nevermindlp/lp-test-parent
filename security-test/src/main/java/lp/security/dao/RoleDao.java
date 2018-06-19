package lp.security.dao;

import java.util.List;

import lp.security.domain.Role;

/**
 * Created by lvpeng01 on 2018/6/15.
 */
public interface RoleDao {

    List<Role> findAll();

    List<Role> findByUserId(int userId);
}
