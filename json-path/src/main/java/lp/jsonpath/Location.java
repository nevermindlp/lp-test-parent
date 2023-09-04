package lp.jsonpath;

/**
 * @author : lvpeng01
 * @since : 2023/4/20
 **/
public class Location {

    public Location() {
    }

    /**
     * 左上角坐标x
     */
    private Float left;

    /**
     * 左上角坐标y
     */
    private Float top;

    /**
     * 宽
     */
    private Float width;

    /**
     * 高
     */
    private Float height;

    private String objectType;

    /**
     * 置信度
     */
    private Float confidence;

    public Float getLeft() {
        return left;
    }

    public void setLeft(Float left) {
        this.left = left;
    }

    public Float getTop() {
        return top;
    }

    public void setTop(Float top) {
        this.top = top;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public Float getConfidence() {
        return confidence;
    }

    public void setConfidence(Float confidence) {
        this.confidence = confidence;
    }
}
