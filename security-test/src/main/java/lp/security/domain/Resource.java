package lp.security.domain;

/**
 * url resource
 *
 * Created by lvpeng01 on 2018/6/13.
 */
public class Resource {

    private Integer id;
    private String url;
    private Integer pid;
    private String desc;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
