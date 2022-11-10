package lp.extend;

/**
 * @author : lvpeng01
 * @since : 2022/7/21
 **/
public class Student extends BaseVo {

    public Student() {
    }

    public Student(String stNo, String belongsClass) {
        this.stNo = stNo;
        this.belongsClass = belongsClass;
    }

    private String stNo;
    private String belongsClass;

    public String getStNo() {
        return stNo;
    }

    public void setStNo(String stNo) {
        this.stNo = stNo;
    }

    public String getBelongsClass() {
        return belongsClass;
    }

    public void setBelongsClass(String belongsClass) {
        this.belongsClass = belongsClass;
    }
}
