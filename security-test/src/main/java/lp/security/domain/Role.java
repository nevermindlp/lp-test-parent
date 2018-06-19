package lp.security.domain;

import java.util.List;

/**
 * 角色组合了资源
 *
 * Created by lvpeng01 on 2018/6/13.
 */
public class Role {

    private Integer id;
    private String name;

    private List<Resource> resources;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
