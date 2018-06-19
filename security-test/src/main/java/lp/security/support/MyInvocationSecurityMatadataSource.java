package lp.security.support;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import lp.security.dao.PermissionDao;
import lp.security.dao.RoleDao;
import lp.security.domain.Role;

/**
 * Created by lvpeng01 on 2018/6/14.
 */
@Component
public class MyInvocationSecurityMatadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private RoleDao roleDao;

    private Map<String, Collection<ConfigAttribute>> configMap = Maps.newHashMap();

    public void loadResourceDefine() {
        Map<String, List<String>> urlAndRoleMap = Maps.newHashMap();
        List<Role> allRoles = roleDao.findAll();
        allRoles.forEach(role -> role.getResources().forEach(resource -> {
            if (null == urlAndRoleMap.get(resource.getUrl())) {
                List<String> roles = Lists.newArrayList();
                roles.add(role.getName());
                urlAndRoleMap.put(resource.getUrl(), roles);
            } else {
                if (!urlAndRoleMap.get(resource.getUrl()).contains(role.getName())) {
                    urlAndRoleMap.get(resource.getUrl()).add(role.getName());
                } else {
                    System.out.println("duplicate url and role match.");
                }
            }
        }));
        urlAndRoleMap.forEach((k, v) -> {
            Collection<ConfigAttribute> configAttributeCollection = Lists.newArrayList();
            v.forEach(roleName -> {
                ConfigAttribute configAttribute = new SecurityConfig(roleName);
                configAttributeCollection.add(configAttribute);
            });
            configMap.put(k, configAttributeCollection);
        });
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (CollectionUtils.isEmpty(configMap)) {
            loadResourceDefine();
        }
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resourceUrl;

        for(Iterator<String> iterator = configMap.keySet().iterator(); iterator.hasNext();) {
            resourceUrl = iterator.next();
            matcher = new AntPathRequestMatcher(resourceUrl);
            if (matcher.matches(request)) {
                return configMap.get(resourceUrl);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
