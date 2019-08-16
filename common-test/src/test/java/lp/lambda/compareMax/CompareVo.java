package lp.lambda.compareMax;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by lvpeng01 on 2019/3/26.
 */
public class CompareVo {

    private int num;
    private int weight;

    public CompareVo(int num, int weight) {
        this.num = num;
        this.weight = weight;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("num", num)
                .append("weight", weight)
                .toString();
    }
}
