package lp.security.dao;

import java.util.List;

import lp.security.domain.Resource;

/**
 * Created by lvpeng01 on 2018/6/13.
 */
public interface PermissionDao {

    List<Resource> findAll();

    List<Resource> findByUserId(int userId);

}
